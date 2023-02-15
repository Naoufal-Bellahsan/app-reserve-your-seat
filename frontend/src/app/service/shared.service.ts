import { Injectable } from '@angular/core';
import { TitleStrategy } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { Building } from './building';
import { Floor } from './floor';
import { Seat } from './seat';

@Injectable({
  providedIn: 'root'
})
export class SharedService {

  
  private seatSubject = new BehaviorSubject<Seat[]>([]);
  private floorSubject = new BehaviorSubject<String>('');
  private adrressSubject = new BehaviorSubject<String>('');
  private citySubject = new BehaviorSubject<String>('');
  private dateSubject = new BehaviorSubject<Date>(new Date());

  currentSeats=this.seatSubject.asObservable();
  currentFloor=this.floorSubject.asObservable();
  currentAdrress=this.adrressSubject.asObservable();
  currentCity=this.citySubject.asObservable();
  currentDate=this.dateSubject.asObservable();

  constructor() { }

  shareData(seats: Seat[], floor:String, adrress:String, city:String, date:Date) {
    this.seatSubject.next(seats);
    this.floorSubject.next(floor);
    this.adrressSubject.next(adrress);
    this.citySubject.next(city);
    this.dateSubject.next(date);
  }

  
}
