import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import { map, catchError } from 'rxjs/operators';
import { environment as env} from 'environments/environment';
import { Establecimiento, Oferta, TipoServicio } from '..';

@Injectable()
export class ServiciosService  {

  constructor(
    private http: Http
  ) {}

  all(): Observable<TipoServicio[]> {
    // const tipoServicios: TipoServicio[] = [
    //   {
    //     id: 1,
    //     nombre: 'Transporte',
    //     servicios: [
    //       { id: 23, nombre: 'servicio de traslado'},
    //       { id: 24, nombre: 'Alquiler de auto'}
    //     ]
    //   },
    //   {
    //     id: 2,
    //     nombre: 'servicio de limpieza',
    //     servicios: [
    //       { id: 45, nombre: 'servicio diario de limpieza' },
    //       { id: 46, nombre: 'servicio de planchado' },
    //       { id: 47, nombre: 'servicio de lavanderia' }
    //     ]
    //   }
    // ];

    // const responseMock: TipoServicio[] = tipoServicios;
    // return this.http.get(`${env.apiUrl}/establecimientos`).pipe(
    const backofficeApi = 'http://152.170.43.218:8080/BackofficeWebServices/rest';
    // const backofficeApi = 'http://192.168.0.150:8080/BackofficeWebServices/rest';
    // const backofficeApi = 'http://192.168.130.104:8080/IA_TPO_BO_G05_DWS/REST';
    return this.http.get(`${backofficeApi}/servicios`).pipe(
      map(response => response.json()),
      // map(response => responseMock),
      catchError(this.handleError)
    );
  }

  private handleError (error: Response | any) {
    console.error('ApiService::handleError', error);
    return Observable.throw(error);
  }
}
