import { Component, OnInit } from '@angular/core';
import {MenuItem} from 'primeng/api';

@Component({
  selector: 'app-topbar',
  templateUrl: './app.topbar.component.html',
})
export class AppTopBarComponent implements OnInit {

    items: MenuItem[];

    ngOnInit() {
        this.items = [
            {
                label: 'CLÍNICA',
                icon: '',
                items: [{
                        label: 'VETERINÁRIO', 
                        icon: '',
                        routerLink: ['/veterinarios']
                    }
                ]
            },
            {
                label: 'PETS',
                icon: '',
                routerLink: ['/pets']
            },
            {
                label: 'AGENDA',
                icon: '',
                items :  [{
                    label: 'CONSULTA', 
                    icon: '',
                    routerLink: ['/consulta']
                },
                {label: 'CALENDÁRIO', 
                icon: '',
                routerLink: ['/agenda']}
            ]
            }
        ];
    }
}