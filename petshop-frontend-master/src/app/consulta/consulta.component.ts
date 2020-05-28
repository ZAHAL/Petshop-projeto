import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { Agenda } from '../agenda/model/agenda';
import { SelectItem } from 'primeng/api/selectitem';
import { Veterinario } from '../veterinario/models/veterinario';
import { ConsultaServive } from './services/consulta.service';
import { VeterinarioService } from '../veterinario/services/veterinario.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-consulta',
  templateUrl: './consulta.component.html',
  styleUrls: ['./consulta.component.css']
})
export class ConsultaComponent implements OnInit {

  form : FormGroup;
  submitedForm = false;
  veterinarioList: SelectItem[];
  tipoAgendamentoList: SelectItem[];
  petList: SelectItem[];
  veterinarios: Veterinario[];
  tipoAgendamentos: any[];
  pets: any[];
  agenda: Agenda = new Agenda();
  msgs: any;
  dataBr: any
  

  constructor(private formBuilder: FormBuilder,
    private consultaService: ConsultaServive,
    private veterinarioService: VeterinarioService,
    private router: Router) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      id: new FormControl(''),
      dataAgendamento: new FormControl('', Validators.required),
      veterinario: new FormControl('', Validators.required),
      tipoAgendamento: new FormControl('', Validators.required),
      pet: new FormControl('', Validators.required)
  }, { updateOn: 'blur' });
  this.formatarCalendario();
  this.carregarVeterinario();
  this.carregarPets();
  this.carregarTipoAgendamento();
  };

  formatarCalendario() {
    this.dataBr = this.funcaoFormatarCalendario();
  }

  funcaoFormatarCalendario() {
    return {
        firstDayOfWeek: 1,
        dayNames: ['Domingo', 'Segunda-Feira', 'Terça-Feira', 'Quarta-Feira', 'Quinta-Feira', 'Sexta-Feira', 'Sábado'],
        dayNamesShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb'],
        dayNamesMin: ['D', 'S', 'T', 'Q', 'Q', 'S', 'S'],
        monthNames: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],
        monthNamesShort: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez']
    };
  }

  carregarVeterinario(){
    this.veterinarioList = [];
    this.veterinarioList.push({ label: 'Selecione um Veterinário', value: null});
    this.veterinarioService.getVeterinarios().subscribe(
      data => {
        this.veterinarios = data;
        for (let v of this.veterinarios) {
        this.veterinarioList.push({ label: v.nome, value: v.id});
        }
      }
    );
  }

  carregarPets(){
    this.petList = [];
    this.petList.push({label: 'Selecione um Pet', value: null});
    this.petList.push({label: 'Melissa', value: 1});
  }

  carregarTipoAgendamento(){
    this.tipoAgendamentoList = [];
    this.tipoAgendamentoList.push({label: 'Selecione o Tipo de Agendamento', value: null});
    this.consultaService.getTipoAgendamentos().subscribe(
      data => {
        this.tipoAgendamentos = data;
        for (let t of this.tipoAgendamentos) {
        this.tipoAgendamentoList.push({ label: t.tipo, value: t.id});
        }
      }
    );
  }

  isValidado(nomeCampo: string) {
    return ((!this.form.controls[nomeCampo].valid && this.form.controls[nomeCampo].touched)
    || (!this.form.controls[nomeCampo].valid && this.submitedForm));
  }

  salvar(){
    if (!this.form.valid) {
      Object.keys(this.form.controls).forEach(campo => {
          this.form.get(campo).markAsTouched();
      });

      this.submitedForm = true;
      return;
    }

    
      this.novo(this.agenda);

  }

  private novo(agenda) {
    agenda.dataRegistro = new Date();
    this.consultaService.salvar(agenda)
        .subscribe(res => {
            this.showSuccess('Registro salvo com sucesso!');
            this.router.navigate(['/agenda']);
        });
  }

  showSuccess(mensagem) {
    this.msgs = [];
    this.msgs.push({severity:'success', summary:'Sucesso', detail:mensagem});
  }
}
