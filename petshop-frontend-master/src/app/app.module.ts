import { AppTopBarComponent } from './app.topbar.component';
import { AppFooterComponent } from './app.footer.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA, LOCALE_ID} from '@angular/core';

import { AppComponent } from './app.component';
import { VeterinarioComponent } from './veterinario/veterinario.component';
import { PetComponent } from './pet/pet.component';
import { AgendaComponent } from './agenda/agenda.component';
import { AppRoutes } from './app.routes';
import {ButtonModule} from 'primeng/button';
import {TableModule} from 'primeng/table';
import { VeterinarioService } from './veterinario/services/veterinario.service';
import { HttpClientModule } from '@angular/common/http';
import {MenubarModule} from 'primeng/menubar';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {PanelModule} from 'primeng/panel';
import {DialogModule} from 'primeng/dialog';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {CalendarModule} from 'primeng/calendar';
import {RadioButtonModule} from 'primeng/radiobutton';
import {DropdownModule} from 'primeng/dropdown';
import {InputMaskModule} from 'primeng/inputmask';
import { ConfirmationService } from 'primeng/api';
import {ConfirmDialogModule} from 'primeng/confirmdialog';
import { NgxMaskModule, IConfig } from 'ngx-mask'
import {MessagesModule} from 'primeng/messages';
import {MessageModule} from 'primeng/message';
import { PetService } from './pet/services/pet.service';
import {FullCalendarModule} from 'primeng/fullcalendar';
import { AgendaService } from './agenda/service/agenda.service';
import { ConsultaComponent } from './consulta/consulta.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { ConsultaServive } from './consulta/services/consulta.service';

const maskConfig: Partial<IConfig> = {
  validation: false,
};

@NgModule({
  declarations: [
    AppComponent,
    VeterinarioComponent,
    PetComponent,
    AgendaComponent,
    AppFooterComponent,
    AppTopBarComponent,
    ConsultaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutes,
    ButtonModule,
    TableModule,
    HttpClientModule,
    MenubarModule,
    PanelModule,
    BrowserModule,
    BrowserAnimationsModule,
    DialogModule,
    FormsModule,
    ReactiveFormsModule,
    CalendarModule,
    RadioButtonModule,
    DropdownModule,
    InputMaskModule,
    ConfirmDialogModule,
    NgxMaskModule.forRoot(maskConfig),
    MessagesModule,
    MessageModule,
    FullCalendarModule,
    FontAwesomeModule
  ],
  providers: [VeterinarioService,
    ConfirmationService,
  PetService,
  AgendaService,
  ConsultaServive,
  { provide: LOCALE_ID, useValue: 'pt-BR' }],
    
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
