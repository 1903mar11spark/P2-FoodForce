import { HttpHeaders, HttpClient } from "@angular/common/http";
import { Injectable } from '@angular/core';
import { Employee } from './emp-info';
import { Observable, of } from 'rxjs';
import { EMP } from './test-temp';


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

export class EmpInfoService{
    constructor (private http:HttpClient){}

    URL: string = 'http://localhost:8084/FoodForce/employee/all';

    getEmps(): Observable<Employee>{

        return this.http.get<Employee>(this.URL, headersOptions);
    }

    getEm(): Observable<Employee>{
        return of(EMP);
    }

}