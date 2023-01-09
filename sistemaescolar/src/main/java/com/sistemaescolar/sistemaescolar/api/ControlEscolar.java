package com.sistemaescolar.sistemaescolar.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaescolar.sistemaescolar.model.request.registrarCalificacionRequest;
import com.sistemaescolar.sistemaescolar.model.response.AlumnoResponse;
import com.sistemaescolar.sistemaescolar.model.response.CalificacionAlumnoResponse;
import com.sistemaescolar.sistemaescolar.model.response.CalificacionResponse;
import com.sistemaescolar.sistemaescolar.model.response.MateriaResponse;
import com.sistemaescolar.sistemaescolar.service.AlumnoService;
import com.sistemaescolar.sistemaescolar.service.CalificacionService;
import com.sistemaescolar.sistemaescolar.service.MateriaService;

@RestController
@CrossOrigin(origins = "*")
public class ControlEscolar {

    private final MateriaService materiaService;
    private final CalificacionService calificacionService;
    private final AlumnoService alumnoService;

    @Autowired
    public ControlEscolar(MateriaService materiaService, CalificacionService calificacionService,
            AlumnoService alumnoService) {
        this.materiaService = materiaService;
        this.calificacionService = calificacionService;
        this.alumnoService = alumnoService;

    }

    @GetMapping("/materias")
    public ResponseEntity<List<MateriaResponse>> materias() {
        List<MateriaResponse> materias = this.materiaService.getMaterias();
        return new ResponseEntity<>(materias, HttpStatus.OK);
    }

    @GetMapping("/alumnos")
    public ResponseEntity<List<AlumnoResponse>> alumnos() {
        List<AlumnoResponse> alumnos = this.alumnoService.getAlumnos();
        return new ResponseEntity<>(alumnos, HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<CalificacionResponse> registrar(
            @RequestBody registrarCalificacionRequest calificacionRequest) {
        CalificacionResponse calificacionResponse = this.calificacionService.registrarCalificacion(calificacionRequest);
        return new ResponseEntity<>(calificacionResponse, HttpStatus.OK);
    }

    @GetMapping("/calificaciones/{idAlumno}")
    public ResponseEntity<List<CalificacionAlumnoResponse>> calificaciones(@PathVariable("idAlumno") Long idAlumno) {
        List<CalificacionAlumnoResponse> calificaciones = this.calificacionService.getCalificacionesAlumno(idAlumno);
        return new ResponseEntity<>(calificaciones, HttpStatus.OK);
    }

    @GetMapping("/calificaciones/{idAlumno}/{idMateria}")
    public ResponseEntity<List<CalificacionAlumnoResponse>> calificacionesMateria(
            @PathVariable("idAlumno") Long idAlumno, @PathVariable("idMateria") Long idMateria) {
        List<CalificacionAlumnoResponse> calificaciones = this.calificacionService
                .getCalificacionesAlumnoMateria(idAlumno, idMateria);
        return new ResponseEntity<>(calificaciones, HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<CalificacionResponse> actualizar(
            @RequestBody registrarCalificacionRequest calificacionRequest) {
        CalificacionResponse calificacionResponse = this.calificacionService.updateCalificacion(calificacionRequest);
        return new ResponseEntity<>(calificacionResponse, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<CalificacionResponse> eliminar(
            @RequestBody registrarCalificacionRequest calificacionRequest) {
        CalificacionResponse calificacionResponse = this.calificacionService.deleteCalificacion(calificacionRequest);
        return new ResponseEntity<>(calificacionResponse, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{idCalificacion}")
    public ResponseEntity<CalificacionResponse> eliminar(@PathVariable("idCalificacion") Long idCalificacion) {
        registrarCalificacionRequest calificacionRequest = new registrarCalificacionRequest();
        calificacionRequest.setIdCalificacion(idCalificacion);
        CalificacionResponse calificacionResponse = this.calificacionService.deleteCalificacion(calificacionRequest);
        return new ResponseEntity<>(calificacionResponse, HttpStatus.OK);
    }

}
