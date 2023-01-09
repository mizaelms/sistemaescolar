import { RegistrarCalificacionRequest } from './../store/model';
import { AlumnosService } from './../services/alumnos.service';
import { MateriasService } from './../services/materias.service';
import { CalificacionesService } from 'src/services/calificaciones.service';
import { Component } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'sistemaescolar-front';

  alumnos: any;
  materias: any;
  calificaciones: any;
  messages: any;
  buttonSave: boolean = false;
  labelButton: string = 'Guardar';

  alumnoSelected: any;
  materiaSelected: any;

  calificacionMateria: any;

  saveOrUpadateFlag: boolean = false;

  registrarCalificacion :RegistrarCalificacionRequest = {
    idAlumno: 0,
    idMateria: 0,
    calificacion: 0,
    idCalificacion: 0
  };




  //property to receive data from button front calificacion number
  calificacionNumber: number = 0;

  constructor(
    private alumnosService: AlumnosService,
    private materiasService: MateriasService,
    private calificacionesService: CalificacionesService
  ) {
    this.alumnosService.getAlumnos().subscribe((data) => {
      this.alumnos = data;
    });

    this.materiasService.getMaterias().subscribe((data) => {
      this.materias = data;
    });
  }

  //event to receive idAlumno an get all materias from calificacionesService
  onGetCalificaciones(alumno: any) {
    this.checkMateria();
    this.calificacionesService
      .getCalificaciones(this.alumnoSelected)
      .subscribe((data) => {
        this.calificaciones = data;
      });
  }

  //event to receive data from button front calificacion number
  onCalificacionAlumno(calificacionNumber: number) {
    console.log('calificacion', calificacionNumber);
    console.log(this.alumnoSelected);
    console.log(this.materiaSelected);
    if(!this.saveOrUpadateFlag){
      this.registrarCalificacion.idAlumno = this.alumnoSelected;
      this.registrarCalificacion.idMateria = this.materiaSelected;
      this.registrarCalificacion.calificacion = calificacionNumber;
      this.calificacionesService.registrarCalificacion(this.registrarCalificacion).subscribe((data) => {
        this.messages = data;
        this.onGetCalificaciones(this.alumnoSelected);
      });
    }else{
      this.registrarCalificacion.idAlumno = this.alumnoSelected;
      this.registrarCalificacion.idMateria = this.materiaSelected;
      this.registrarCalificacion.calificacion = calificacionNumber;
      this.registrarCalificacion.idCalificacion = this.calificacionMateria[0].id;
      this.calificacionesService.actualizaCalificacion(this.registrarCalificacion).subscribe((data) => {
        this.messages = data;
        this.onGetCalificaciones(this.alumnoSelected);
      });
    }
  }

  //event to receive data from button front calificacion number
  onMateria(materia: any) {
    this.checkMateria();

  }

  checkMateria() {
    //verify if alumnoSelected is not null and materiaSelected is not null
    if (this.alumnoSelected != null && this.materiaSelected != null) {
      this.buttonSave = true;

      //get calificacion from alumno and materia and check status 200
      this.calificacionesService
        .getCalificacion(this.alumnoSelected, this.materiaSelected)
        .subscribe((data) => {
          this.calificacionMateria = data;
          //check if calificacionMateria is not null and length is greater than 0
          if (this.calificacionMateria != null && this.calificacionMateria.length > 0) {
            this.labelButton = 'Actualizar';
            this.calificacionNumber = this.calificacionMateria[0].calificacion;
            this.saveOrUpadateFlag = true;
            console.log('calificacionNumber', this.calificacionNumber);
          }
        }, (error: HttpErrorResponse) => {
          this.labelButton = 'Guardar'
          this.calificacionNumber=0;
          this.saveOrUpadateFlag = false;
         });
    }
  }

  //event to receive idCalificacion and delete this
  onDeleteCalificacion(idCalificacion: number) {
    this.calificacionesService.eliminarCalificacion(idCalificacion).subscribe((data) => {
      this.messages = data;
      this.onGetCalificaciones(this.alumnoSelected);
    });
  }
}
