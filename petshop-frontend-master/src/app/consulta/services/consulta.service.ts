import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TipoAgendamento } from '../models/tipo-gendamento';
import { Agenda } from 'src/app/agenda/model/agenda';

@Injectable()
export class ConsultaServive {

    resurceTipoAgendamentoUrl = 'api/tipoagendamento';

    constructor(private http: HttpClient) {}

    getTipoAgendamentos (): Observable<TipoAgendamento[]> {
        return this.http.get<TipoAgendamento[]>(this.resurceTipoAgendamentoUrl);
    }

    salvar(agenda: Agenda): Observable<Agenda> {
        return this.http.post<any>('api/agenda', agenda);
}

}