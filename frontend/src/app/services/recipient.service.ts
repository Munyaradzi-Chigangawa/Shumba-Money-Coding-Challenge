import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Observable } from 'rxjs';
import { Recipient } from '../models/recipient';

@Injectable({
  providedIn: 'root'
})
export class RecipientService {

  private baseUrl = 'http://localhost:8080/api/v1';

  constructor(private httpClient : HttpClient) { }

  // Consuming Read All Endpoint
  public getRecipientsList() : Observable<Recipient[]> {
    return this.httpClient.get<Recipient[]>(`${this.baseUrl}/getRecipients?senderId=${localStorage.getItem("senderId")}`);
  }

  // Consuming Read By Id Endpoint
  public getRecipient (recipientId: number): Observable<Recipient> {
    return this.httpClient.get<Recipient>(`${this.baseUrl}/getRecipient/${recipientId}`)
    }

  // Consuming Create Endpoint
  public addRecipient (recipient: Recipient): Observable<Recipient> {
    return this.httpClient.post<Recipient>(`${this.baseUrl}/addRecipient?senderId=${localStorage.getItem("senderId")}`, recipient)
  }

  // Consuming Update Endpoint
  public updateRecipient (recipientId: number, recipient: Recipient): Observable<Recipient> {
    return this.httpClient.put<Recipient>(`${this.baseUrl}/updateRecipient/${recipientId}?senderId=${localStorage.getItem("senderId")}`, recipient)
  }

  // Consuming Delete Endpoint
  public deleteRecipient (recipientId: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.baseUrl}/deleteRecipient/${recipientId}`)
  }
}
