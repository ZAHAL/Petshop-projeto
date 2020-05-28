import { element } from 'protractor';
import { Especialidade } from './../../../especialidade';
import { VeterinarioService } from './services/veterinario.service';
import { Veterinario } from './models/veterinario';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { SelectItem } from 'primeng/api/selectitem';
import { Table } from 'primeng/table/table';
import { ConfirmationService, Message } from 'primeng/api';
import { BlockUI, NgBlockUI } from 'ng-block-ui';

@Component({
  selector: 'app-veterinario',
  templateUrl: './veterinario.component.html',
  styleUrls: ['./veterinario.component.css']
})
export class VeterinarioComponent implements OnInit {

  veterinarios : Veterinario[] = [];
  display: boolean = false;
  form : FormGroup;
  veterinario:  Veterinario = new Veterinario();
  dataBr: any;
  val1: string;
  especialidades: Especialidade[];
  especialidadesList: SelectItem[];
  table: Table;
  submitedForm = false;
  cols: any[];
  editar: boolean;
  novo: boolean;
  @BlockUI() blockUI: NgBlockUI;
  msgs: Message[] = [];

  constructor(private veterinarioService: VeterinarioService,
    private formBuilder: FormBuilder,
    private confirmationService: ConfirmationService) { }

  ngOnInit() {
    this.cols = [
      { field: 'nome', header: 'Nome' },
      { field: 'especialidade', header: 'Especialidade' }
    ];
    this.formatarCalendario();
    this.form = this.formBuilder.group({
      id: new FormControl(''),
      nome: new FormControl('', Validators.required),
      dataNascimento: new FormControl('', Validators.required),
      sexo: new FormControl('', Validators.required),
      cpf: new FormControl('', Validators.required),
      especialidade: new FormControl('', Validators.required)
  }, { updateOn: 'blur' });

    this.carregarVeterianarios();
    this.carregarEspecialidade();
  }

  carregarVeterianarios(){
    this.veterinarioService.getVeterinarios()
    .subscribe(veterinarios => {
      this.veterinarios = veterinarios
    });
  }

  formatarCalendario() {
    this.dataBr = this.funcaoFormatarCalendario();
  }

  mostrarEspecialida(element) {
    let result;
    for (let i =0; i < this.especialidades.length; i++) {
      if(element == this.especialidades[i].id){
        result = this.especialidades[i].tipo;
      }
    }
    return result;
  }

  carregarEspecialidade(){
    this.especialidadesList = [];
    this.especialidadesList.push({ label: 'Selecione a Especialidade', value: null});
    this.veterinarioService.getEspecialidades().subscribe(
      data => {
        this.especialidades = data;
        for (let e of this.especialidades) {
        this.especialidadesList.push({ label: e.tipo, value: e.id});
        }
      }
    );
  }

  showSuccess(mensagem) {
    this.msgs = [];
    this.msgs.push({severity:'success', summary:'Sucesso', detail:mensagem});
  }

  funcaoFormatarCalendario() {
    return {
        firstDayOfWeek: 1,
        dayNames: ['Domingo', 'Segunda-Feira', 'Terça-Feira', 'Quarta-Feira', 'Quinta-Feira', 'Sexta-Feira', 'Sábado'],
        dayNamesShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb'],
        dayNamesMin: ['D', 'S', 'T', 'Q', 'Q', 'S', 'S'],
        monthNames: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],
        monthNamesShort: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],
        today: 'Hoje',
        clear: 'Limpar'
    };
  }
  
  cadastrar() {
    this.display = true;
    this.novo = true;
    this.limparModal();
  }

  limparModal() {
    this.veterinario = new Veterinario();
    this.resetarFormulario();
  }

  resetarFormulario() {
    this.submitedForm = false;
    this.editar = false;
      this.form.reset();
}


  handleClick(event) {

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

    if (this.novo) {
      this.novoVeterinario(this.veterinario);
    }
    if (this.editar) {
      this.editarVeterinario(this.veterinario);
    }

  }

  dataAtualFormatada(data){
    data = new Date(data);
    return data.toLocaleString();
  }

  formataStringData(data) {
    var dia  = data.split("/")[0];
    var mes  = data.split("/")[1];
    var ano  = data.split("/")[2];
    return ano + '-' + ("0"+mes).slice(-2) + '-' + ("0"+dia).slice(-2);
  }

  private novoVeterinario(veterinario) {
    this.veterinarioService.salvar(veterinario)
        .subscribe(res => {
            this.display = false;
            let veterinarios = [...this.veterinarios];
            veterinarios.push(res);
            this.veterinarios = veterinarios;
            this.showSuccess('Registro salvo com sucesso!');
        });
  }

  private editarVeterinario(veterinario){
    veterinario.tipoEspecialidade = "";
    this.veterinarioService.edit(veterinario)
    .subscribe(res => {
        this.display = false;
        let index = this.table.value.indexOf(veterinario);
        this.table.value.splice(index, 1);
        this.veterinarios = this.table.value;
        let veterinarios = [...this.veterinarios];
        veterinarios.push(res);
        this.veterinarios = veterinarios;
        this.showSuccess('Registro alterado com sucesso!');
    });

  }

  deletarCliente(veterinario: any, table: Table) {
    this.confirmarDeletar(veterinario, table);
  }

  confirmarDeletar(veterinario: any, table: Table) {
    const icon = 'ui-icon-circle-close';
    this.confirmationService.confirm({
      message: 'Deseja realmente excluir este registro?',
      header: 'Exclusão de Registro',
      icon: 'fa fa-question-circle',
      accept: () => {
          this.delete(veterinario, table);
      }
    });
  }

  delete(veterinario: any, table: Table): void {
    this.veterinarioService.delete(veterinario.id).subscribe(res => {
      let index = table.value.indexOf(veterinario);
      table.value.splice(index, 1);
      this.showSuccess('Registro excluído com sucesso!');
    });
  }

  abrirEditar(veterinario: any, table: Table) {
    this.novo = false;
    this.editar = true;
    this.table = table;
    this.editar = true;
    veterinario.dataNascimento = new Date(veterinario.dataNascimento);
    this.veterinario = veterinario;
    this.display = true;
  }



}
