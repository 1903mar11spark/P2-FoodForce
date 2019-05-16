import { HttpHeaders, HttpClient } from "@angular/common/http";
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';



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


}