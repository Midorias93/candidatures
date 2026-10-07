import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Candidature, CandidaturePayload, Stats } from '../models/candidature.model';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CandidatureService {
  private http = inject(HttpClient);

  getAll(): Observable<Candidature[]> {
    return this.http.get<Candidature[]>(environment.apiUrl + '/candidatures');
  };

  getById(id: number): Observable<Candidature> {
    return this.http.get<Candidature>(environment.apiUrl + `/candidatures/${id}`);
  }

  getStats(): Observable<Stats> {
    return this.http.get<Stats>(environment.apiUrl + '/candidatures/stats');
  }

  create(body: CandidaturePayload): Observable<Candidature> {
    return this.http.post<Candidature>(environment.apiUrl + '/candidatures', body);
  }

  update(id:number, body: CandidaturePayload): Observable<Candidature> {
    return this.http.put<Candidature>(environment.apiUrl + `/candidatures/${id}`, body);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(environment.apiUrl + `/candidatures/${id}`);
  }

}
