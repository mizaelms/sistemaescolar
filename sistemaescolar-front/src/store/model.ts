
/* inferface from this entity public class CalificacionAlumnoResponse {

    private Long idUsuario;
    private String nombre;
    private String apellidoPaterno;
    private String materia;
    private Long calificacion;
    private Date fechaRegistro;

} */

export interface CalificacionAlumnoResponse {
    id: number;
    idUsuario: number;
    nombre: string;
    apellidoPaterno: string;
    materia: string;
    calificacion: number;
    fechaRegistro: Date;
}

/* inferface from this entity public class public class AlumnoResponse {

    private Long id;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private Boolean activo;
} */

export interface AlumnoResponse {
    id: number;
    nombre: string;
    apPaterno: string;
    apMaterno: string;
    activo: boolean;
}

/* inferface from this entity public class public class MateriaResponse {
    private Long id;
    private String nombre;
    private String descripcion;
    private Boolean activo;
} */

export interface MateriaResponse {
    id: number;
    nombre: string;
    descripcion: string;
    activo: boolean;
}


export interface Configuration {
  apiUrl: string;
}

/* inferface from this entity public class public class public class registrarCalificacionRequest {

    private Long idCalificacion;
    private Long idMateria;
    private Long calificacion;
    private Long idAlumno;
}

  */

export interface RegistrarCalificacionRequest {
    idCalificacion: number;
    idMateria: number;
    calificacion: number;
    idAlumno: number;
}


