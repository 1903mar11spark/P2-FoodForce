import { HttpHeaders, HttpClient } from "@angular/common/http";
import { Injectable } from '@angular/core';
import { Customer } from './cust-info';
import { Observable, of } from 'rxjs';
import { Cust } from './test-cust';


const headersOptions = {
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

export class CustInfoService{
    constructor (private http:HttpClient){}
//change URL
    URL: string = 'http://localhost:8084/FoodForce/employee/all';

    getCusts(): Observable<Customer>{

        return this.http.get<Customer>(this.URL, headersOptions);
    }

    getCust(): Observable<Customer>{
        return of(Cust);
    }

}