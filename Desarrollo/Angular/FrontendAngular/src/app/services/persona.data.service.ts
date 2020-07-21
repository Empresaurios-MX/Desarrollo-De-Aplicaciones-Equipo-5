import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { Persona } from '../models/persona';
import Swal from 'sweetalert2';

@Injectable()
export class PersonaDataService {

  apiURL = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*',
      Accept: 'application/json'
    })
  };

  create(persona: Persona): Observable<Persona> {
    return this.http.post<Persona>(this.apiURL + '/personas', persona, this.httpOptions).pipe(retry(1), catchError(this.handleError));
  }

  get(id): Observable<Persona> {
    return this.http.get<Persona>(this.apiURL + '/personas/' + id, this.httpOptions).pipe(retry(1), catchError(this.handleError));
  }

  getAll() {
    return this.http.get<Persona>(this.apiURL + '/personas', this.httpOptions).pipe(retry(1), catchError(this.handleError));
  }

  update(persona: Persona): Observable<Persona> {
    return this.http.put<Persona>(this.apiURL + '/personas', persona, this.httpOptions).pipe(retry(1), catchError(this.handleError));
  }

  delete(id) {
    return this.http.delete<Persona>(this.apiURL + '/personas/' + id, this.httpOptions).pipe(retry(1), catchError(this.handleError));
   }

  handleError(error) {
    let errorMessage;

    if (error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error.message;
    } else {
      // Get server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }

    Swal.fire('Error', 'Algo ha salido mal, por favor intentalo más tarde', 'error');

    return throwError(errorMessage);
  }
}
