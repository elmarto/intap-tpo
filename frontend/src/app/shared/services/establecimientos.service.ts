import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import { map, catchError } from 'rxjs/operators';
import { environment as env} from 'environments/environment';
import { Establecimiento } from '..';

@Injectable()
export class EstablecimientosService  {

  constructor(
    private http: Http
  ) {}

  all(): Observable<Establecimiento[]> {
    const establecimiento: Establecimiento = {
      id: 1,
      uid: 'asdfasdfasd',
      nombre: 'Sheraton Mar del Plata',
      direccion: 'San Martin 132',
      ciudad: 'Mar del Plata',
      estrellas: Math.ceil(Math.random() * 5),
      hotel: {
        id: 1,
        nombre: 'Sheraton',
        fotosHotel: [{ url: '' }]
      },
      descripcion: 'Hotel frente al mar',
      mapa: { url: '' },
      fotosEstablecimiento: [{ url: '' }]
    };
    const responseMock: Establecimiento[] = [establecimiento, establecimiento, establecimiento];
    return this.http.get(`${env.apiUrl}/establecimientos`).pipe(
    // return this.http.get(`http://calapi.inadiutorium.cz/api/v0/en/calendars`).pipe(
      map(response => response.json()),
      // map(response => responseMock),
      catchError(this.handleError)
    );
  }

  create(request) {
    return this.http.post(`${env.apiUrl}/establecimientos`, request).pipe(
      map(response => response.json()),
      catchError(this.handleError)
    );
  }

  private handleError (error: Response | any) {
    console.error('ApiService::handleError', error);
    return Observable.throw(error);
  }
}
