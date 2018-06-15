import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import { map, catchError } from 'rxjs/operators';
import { environment as env} from 'environments/environment';
import { Establecimiento, Oferta } from '..';

@Injectable()
export class OfertasService  {

  constructor(
    private http: Http
  ) {}

  all(): Observable<Oferta[]> {
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
    const oferta: Oferta = {
      id: 1,
      nombre: 'Oferta Hotelera 1',
      precio: 1187.99,
      cupo: 3,
      tipoHabitacion: 'TRIPLE',
      mediosDePago: 'Tarjeta Visa, Tarjeta Mastercard',
      establecimiento: establecimiento,
      fechaDesde: '2018-06-20T12:30-02:00',
      fechaHasta: '2018-06-29T12:30-02:00',
      politicas: 'Solo se puede cancelar una semana antes, excepción por enfermedad',
      servicios: 'WIFI, Parking, Desayuno, Pileta, Baño Privado'
   }
   ;
    const responseMock: Oferta[] = [oferta, oferta];
    return this.http.get(`${env.apiUrl}/ofertas`).pipe(
    // return this.http.get(`http://calapi.inadiutorium.cz/api/v0/en/calendars`).pipe(
      map(response => response.json()),
      // map(response => responseMock),
      catchError(this.handleError)
    );
  }

  create(request) {
    return this.http.post(`${env.apiUrl}/ofertas`, request).pipe(
      map(response => response.json()),
      catchError(this.handleError)
    );
  }

  private handleError (error: Response | any) {
    console.error('ApiService::handleError', error);
    return Observable.throw(error);
  }
}
