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
<<<<<<< HEAD
        'Accept': 'application/json'
=======
    'Accept': 'application/json',
    'Access-Control-Allow-Origin' : '*'
>>>>>>> 859a1638ec78a99fbb7f2df41418e8cbdde167a2
    })
} 

@Injectable({
    providedIn: 'root'
})

export class MenuPizzaService{
    constructor (private http:HttpClient){}


    URL: string = 'localhost:8084/FoodForce/food/all/';

<<<<<<< HEAD
    getQuests(): Observable<Menu[]>{
 
        return this.http.get<Menu[]>(this.URL, heetOptions);
=======
    getQuests(): Observable<Order>{

        return this.http.get<Order>(this.URL, heetOptions);
>>>>>>> 859a1638ec78a99fbb7f2df41418e8cbdde167a2
    }

    // getPiz(): Observable<Menu[]>{
    //     return of(PIZ);
    // }
}