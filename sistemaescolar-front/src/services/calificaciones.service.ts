import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { config } from 'src/config/local';
import { RegistrarCalificacionRequest } from 'src/store/model';

@Injectable({
  providedIn: 'root'
})
export class CalificacionesService {

  urlRegistrar = `${config.apiUrl}/registrar`;

  urlActualizar = `${config.apiUrl}/actualizar`;

  urlCalificaciones = `${config.apiUrl}/calificaciones`;

  urlEliminarCalificacion = `${config.apiUrl}/eliminar`;

  constructor(private http: HttpClient) { }

  registrarCalificacion(request: RegistrarCalificacionRequest) {
    return this.http.post(this.urlRegistrar, request);
  }

  actualizaCalificacion(request: RegistrarCalificacionRequest) {
    return this.http.put(this.urlActualizar, request);
  }

  // method to get all calificaciones received id user and concatenated with url
  getCalificaciones(id: number) {
    return this.http.get(`${this.urlCalificaciones}/${id}`);
  }

  getCalificacion(id: number, idMateria: number) {
    return this.http.get(`${this.urlCalificaciones}/${id}/${idMateria}`);
  }

  eliminarCalificacion(idCalificacion: number) {
    return this.http.delete(`${this.urlEliminarCalificacion}/${idCalificacion}`);
  }


}
