import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http:HttpClient) { }


  GetComments(){

      //return this.http.get('https://jsonplaceholder.typicode.com/posts');



      return fetch('http://localhost:8084/FoodForce/order/1');





  }
}
