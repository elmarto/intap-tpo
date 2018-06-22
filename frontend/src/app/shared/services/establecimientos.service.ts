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
    return this.http.get(`${env.apiUrl}/establecimientos`).pipe(
      map(response => response.json()),
      catchError(this.handleError)
    );
  }

  getCiudades(): Observable<any> {
    return this.http.get(`assets/json/ciudades.json`).pipe(
      map(response => response.json()),
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
