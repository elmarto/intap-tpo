import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import { map, catchError } from 'rxjs/operators';
import { environment as env} from 'environments/environment';

@Injectable()
export class EstablecimientosService  {

  constructor(
    private http: Http
  ) {}

  all() {
    const hotel = {
      id: 1,
      uid: 'asdfasdfasd',
      nombre: 'Sheraton Mar del Plata',
      direccion: 'San Martin 132',
      ciudad: 'Mar del Plata',
      estado: 'ACTIVO', // INACTIVO, ACTIVO
      hotel: {
        id: 1,
        nombre: 'Sheraton',
        fotosHotel: [{ url: '' }]
      }
      ,
      descripcion: 'Hotel frente al mar',
      mapa: { url: '' },
      fotosEstablecimiento: [{ url: '' }]
    };
    const responseMock = {establecimientos: [hotel, hotel, hotel]};
      // return this.http.get(`${env.apiUrl}/establecimientos`).pipe(
      return this.http.get(`http://calapi.inadiutorium.cz/api/v0/en/calendars`).pipe(
        // map(response => response.json()),
        map(response => responseMock),
        catchError(this.handleError)
      );
  }

  private handleError (error: Response | any) {
    console.error('ApiService::handleError', error);
    return Observable.throw(error);
  }
}
