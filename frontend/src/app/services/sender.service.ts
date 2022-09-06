import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Sender } from '../models/sender';

@Injectable({
  providedIn: 'root'
})
export class SenderService {
  private baseUrl = 'http://localhost:8080/api/v1';

  constructor( private httpClient : HttpClient) { }

  // Consuming Read All Endpoint
  public getSendersList() : Observable<Sender[]> {
    return this.httpClient.get<Sender[]>(`${this.baseUrl}/getSenders`);
  }

}
