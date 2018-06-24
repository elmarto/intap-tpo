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
    return this.http.get(`${env.apiUrl}/ofertas`).pipe(
      map(response => response.json()),
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
