import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';



@Injectable({
    providedIn: 'root'
})

export class CustomerOrderHistoryService{
    constructor (private http:HttpClient){}

    id=1

    getHistory(){
        return fetch('http://localhost:8084/FoodForce/order/'+this.id)
      }
    }