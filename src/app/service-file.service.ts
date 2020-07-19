import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import {  throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ServiceFileService {

  constructor(
    private http: HttpClient) {}
  
    private apiServer = 'http://localhost:8083'; 

    httpOptions = {
        headers: new HttpHeaders({ 'Content-Type': 'application/json' })
      };

      private headers = new HttpHeaders({ 'Content-Type': 'application/json' });


      getFlights(source,destination,sort): Observable<Object[]> {
        return this.http.get<Object[]>(this.apiServer + '/flights/'+source+'/'+destination+'/'+sort)
        .pipe(
          catchError(this.errorHandler)
        )
      }

      getAllFlights(source,destination): Observable<Object[]> {
        return this.http.get<Object[]>(this.apiServer + '/flights/'+source+'/'+destination)
        .pipe(
          catchError(this.errorHandler)
        )
      }

      
      errorHandler(error) {
        let errorMessage = '';
        if(error.error instanceof ErrorEvent) {
          // Get client-side error
          errorMessage = error.error.message;
        } else {
          // Get server-side error
          errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
        }
        console.log(errorMessage);
        return throwError(errorMessage);
     }

}
