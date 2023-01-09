import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { AlumnoResponse } from 'src/store/model';
import { config } from 'src/config/local';

@Injectable({
  providedIn: 'root'
})
export class AlumnosService {

  publicUrl = `${config.apiUrl}/alumnos`;

  getAlumnos() {
    return this.http.get<AlumnoResponse[]>(this.publicUrl);
  }

  constructor(private http: HttpClient) { }

}
