import { HttpClient, HttpHeaders } from '@angular/common/http';
import { of, Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { Order } from '../order';
import { ORD } from '../test-orders';

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

export class EmpAcceptService{

    constructor (private http:HttpClient){}

    //URL; string

    getAccepted(): Observable<Order[]>{
        return of(ORD)
    }
}