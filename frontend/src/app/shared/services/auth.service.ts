import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import { map, catchError } from 'rxjs/operators';
import { environment as env} from 'environments/environment';

@Injectable()
export class AuthService  {

  constructor(
    private http: Http
  ) {}

  all(request) {
      return this.http.get(`${env.apiUrl}/auth`).pipe(
        map(response => response.json()),
        catchError(this.handleError)
      );
  }

  private handleError (error: Response | any) {
    console.error('ApiService::handleError', error);
    return Observable.throw(error);
  }
}
