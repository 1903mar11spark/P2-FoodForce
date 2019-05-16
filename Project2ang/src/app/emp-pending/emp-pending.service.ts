import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { ORD } from '../test-orders';
import { Injectable } from '@angular/core';
import { Order } from '../order';



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

export class EmpPendingService{

    constructor (private http:HttpClient){}

    //URL: string = ''

    // getPend(): Observable<Order[]>{
    //     return of(ORD)
    // }
    getPend(){
        return fetch('')

    }

}

