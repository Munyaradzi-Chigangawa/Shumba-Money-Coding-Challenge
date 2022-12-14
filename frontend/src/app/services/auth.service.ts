import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Sender } from '../models/sender';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private baseUrl = 'http://localhost:8080/api/v1';

  constructor(private httpClient: HttpClient) { }

  // Login
  login(sender: Sender): Observable<Sender> {
    return this.httpClient.post<any>(`${this.baseUrl}/login`, sender);
  }
}

