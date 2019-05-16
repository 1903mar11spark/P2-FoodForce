import { HttpHeaders, HttpClient } from '@angular/common/http';

import { Injectable } from '@angular/core';


const headOptions = {
    headers: new HttpHeaders({  
        'Access-Control-Allow-Origin': 'http://localhost:4200',  
        'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,OPTIONS',
        'Access-Control-Allow-Headers': '*',
        'Content-Type': 'application/json',
        'Accept': 'application/json'
    })
} 

@Injectable({
    providedIn: 'root'
})

export class EmpMadeService{

    constructor (private http:HttpClient){}

    getMade(){
        return fetch('http://localhost:8084/FoodForce/order/get-by-status/Complete')

    }

}