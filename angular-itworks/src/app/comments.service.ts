import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http:HttpClient) { }


  GetComments(){

      return fetch('http://localhost:8084/FoodForce/order/1');

  }
}
