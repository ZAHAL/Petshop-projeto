import { Especialidade } from './../../../../especialidade';
import { Veterinario } from './../models/veterinario';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';



@Injectable()
export class VeterinarioService {


    resourceUrl = 'api/veterinarios';
    resurceEspecialidadeUrl = 'api/especialidades';

    constructor(private http: HttpClient) {}

    getVeterinarios (): Observable<Veterinario[]> {
        return this.http.get<Veterinario[]>(this.resourceUrl);
    }

    salvar(veterinario: Veterinario): Observable<Veterinario> {
            return this.http.post<any>('api/veterinario', veterinario);
    }

    delete(id){
        return this.http.delete('api/veterinario'+'/'+id);
    }

    getEspecialidades (): Observable<Especialidade[]> {
        return this.http.get<Especialidade[]>(this.resurceEspecialidadeUrl);
    }

    edit(veterinario: Veterinario): Observable<Veterinario> {
        return this.http.put<any>('api/veterinario/editar', veterinario);
    }

    
}
