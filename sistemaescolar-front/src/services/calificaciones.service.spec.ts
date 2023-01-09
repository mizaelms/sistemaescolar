/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { CalificacionesService } from './calificaciones.service';

describe('Service: Calificaciones', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CalificacionesService]
    });
  });

  it('should ...', inject([CalificacionesService], (service: CalificacionesService) => {
    expect(service).toBeTruthy();
  }));
});
