import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {Menu} from '../menu';
import { PIZ } from './test-pizza';


const heetOptions = {
    headers: new HttpHeaders({  
        'Access-Control-Allow-Origin': 'http://localhost:4200',  
        'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,OPTIONS',
        'Access-Control-Allow-Headers': '*',
        'Content-Type': 'application/json',
    'Accept': 'application/json',
  
    })
} 

@Injectable({
    providedIn: 'root'
})

export class MenuPizzaService{
    constructor (private http:HttpClient){}


    URL: string = 'localhost:8084/FoodForce/food/all/';

    getQuests(){
 
        return fetch('http://localhost:8084/FoodForce/food/all');

       // return this.http.get<Menu[]>(this.URL, heetOptions);
    }

    // getPiz(): Observable<Menu[]>{
    //     return of(PIZ);
    // }
}