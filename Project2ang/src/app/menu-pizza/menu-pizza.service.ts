import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Order} from '../order';


const heetOptions = {
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

export class MenuPizzaService{
    constructor (private http:HttpClient){}


    URL: string = 'localhost:8084/FoodForce/food/';

    getQuests(): Observable<Order>{
 
        return this.http.get<Order>(this.URL, heetOptions);
    }
}