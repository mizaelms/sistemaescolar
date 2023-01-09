import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MateriasService {

  constructor(private http: HttpClient) { }

  publicUrl = 'http://localhost:8080/materias';

  getMaterias() {
    return this.http.get(this.publicUrl);
  }

}
