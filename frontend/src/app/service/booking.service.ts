import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Booking } from './booking';
import { BookingPostBody } from './bookingPostBody';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  // Esta url obtiene el listado de las reservas en el back-end
  private baseURL = "http://localhost:8080/api/reservation/";

  constructor(private httpClient : HttpClient) { }

  // Este método nos sirve para obtener las reservas, un observable es un patrón de diseño
  obtenerListadoDeReservas():Observable<Booking[]>{
    return this.httpClient.get<Booking[]>(`${this.baseURL}`);
  }
  // olek: método para eliminar las reservas
  deleteReservation(id: number): Observable<Booking> {
    return this.httpClient.delete<Booking>(`${this.baseURL}delete/${id}`);
  }
  // método crear reserva
  createReservation(bookingPostBody:BookingPostBody): Observable<Booking> {
    return this.httpClient.post<Booking>(`${this.baseURL}reserve/`,bookingPostBody);
  }
}
