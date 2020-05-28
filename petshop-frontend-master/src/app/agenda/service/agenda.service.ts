import { Injectable, NgModule, LOCALE_ID } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class AgendaService {

  resurceUrl = 'api/agenda';

    constructor(private http: HttpClient) {}

    getEvents() {
        return this.http.get<any>(this.resurceUrl+'/json')
          .toPromise()
          .then(res => <any[]>res)
          .then(data => { return data; });
        }

}