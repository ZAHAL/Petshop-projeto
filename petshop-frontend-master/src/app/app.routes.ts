import { NgModule, ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { VeterinarioComponent } from './veterinario/veterinario.component';
import { PetComponent } from './pet/pet.component';
import { AgendaComponent } from './agenda/agenda.component';
import { ConsultaComponent } from './consulta/consulta.component';

export const routes: Routes = [
  { path: 'veterinarios', component: VeterinarioComponent },
  { path: 'pets', component: PetComponent },
  { path: 'agenda', component: AgendaComponent },
  { path:'consulta', component: ConsultaComponent}

];

export const AppRoutes: ModuleWithProviders = RouterModule.forRoot(routes);
