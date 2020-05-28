import { Pet } from '../models/pet';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';



@Injectable()
export class PetService {


    resourceUrl = 'api/pets';

    constructor(private http: HttpClient) {}

    
    getPets (): Observable<Pet[]> {
        return this.http.get<Pet[]>(this.resourceUrl);
    }

    salvar(pet: Pet): Observable<Pet> {
            return this.http.post<any>('api/pet', pet);
    }

    delete(id){
        return this.http.delete('api/pet'+'/'+id);
    }

    edit(veterinario: Pet): Observable<Pet> {
        return this.http.put<any>('api/pet/editar', veterinario);
    }

    
}
