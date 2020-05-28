import { PetService } from './services/pet.service';
import { Pet } from './models/pet';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Table } from 'primeng/table/table';
import { ConfirmationService, Message } from 'primeng/api';;

@Component({
  selector: 'app-Pets',
  templateUrl: './pet.component.html',
  styleUrls: ['./pet.component.css']
})
export class PetComponent implements OnInit {

  pets : Pet[] = [];
  display: boolean = false;
  form : FormGroup;
  pet:  Pet = new Pet();
  submitedForm = false;
  novo: boolean;
  editar: boolean;
  table: Table;
  msgs: Message[] = [];

  val2: string = 'Option 2';
  constructor(private petsService: PetService,
    private formBuilder: FormBuilder,
    private confirmationService: ConfirmationService) { }

  ngOnInit() {
    this.form = this.formBuilder.group({
      id: new FormControl(''),
      especie: new FormControl('', Validators.required),
      raca: new FormControl('', Validators.required),
      nome: new FormControl('', Validators.required),
      nomeCliente: new FormControl('', Validators.required),
      genero: new FormControl('', Validators.required),
      idade: new FormControl('', Validators.required),
  }, { updateOn: 'blur' });

    this.petsService.getPets()
    .subscribe(pets => this.pets = pets);


  }

  isValidado(nomeCampo: string) {
    return ((!this.form.controls[nomeCampo].valid && this.form.controls[nomeCampo].touched)
    || (!this.form.controls[nomeCampo].valid && this.submitedForm));
  }



  cadastrar() {
    this.display = true;
    this.novo = true;
  }

  limparModal() {
    this.pet = new Pet();
    this.resetarFormulario();
  }

  resetarFormulario() {
    this.submitedForm = false;
      this.form.reset();
}

  handleClick(event) {

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
      this.novoPet(this.pet);
    }
    if (this.editar) {
     this.editarPet(this.pet);
    }

  }


  private novoPet(pet) {
    this.petsService.salvar(pet)
        .subscribe(res => {
            this.display = false;
            let pets = [...this.pets];
            pets.push(pet);
            this.pets = pets;
        });
  }

  deletar(pet: any, table: Table) {
    this.confirmarDeletar(pet, table);
  }

  showSuccess(mensagem) {
    this.msgs = [];
    this.msgs.push({severity:'success', summary:'Sucesso', detail:mensagem});
  }

  private editarPet(pet){
    pet.tipoEspecialidade = "";
    this.petsService.edit(pet)
    .subscribe(res => {
        this.display = false;
        let index = this.table.value.indexOf(pet);
        this.table.value.splice(index, 1);
        this.pets = this.table.value;
        let pets = [...this.pets];
        pets.push(res);
        this.pets = pets;
        this.showSuccess('Registro alterado com sucesso!');
    });

  }

  deletarCliente(pet: any, table: Table) {
    this.confirmarDeletar(pet, table);
  }

  confirmarDeletar(pet: any, table: Table) {
    const icon = 'ui-icon-circle-close';
    this.confirmationService.confirm({
      message: 'Deseja realmente excluir este registro?',
      header: 'Exclusão de Registro',
      icon: 'fa fa-question-circle',
      accept: () => {
          this.delete(pet, table);
      }
    });
  }

  delete(pet: any, table: Table): void {
    this.petsService.delete(pet.id).subscribe(res => {
      let index = table.value.indexOf(pet);
      table.value.splice(index, 1);
      this.showSuccess('Registro excluído com sucesso!');
    });
  }

  abrirEditar(pet: any, table: Table) {
    this.novo = false;
    this.editar = true;
    this.table = table;
    this.editar = true;
    pet.dataNascimento = new Date(pet.dataNascimento);
    this.pet = pet;
    this.display = true;
  }
}
