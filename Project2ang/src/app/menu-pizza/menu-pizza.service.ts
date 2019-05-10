import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Order} from '../order';


const heetOptions = {
    headers: new HttpHeaders({  
        'Content-Type': 'application/json',
    'Accept': 'application/json',
    'Access-Control-Allow-Origin' : '*'
    })
} 

@Injectable({
    providedIn: 'root'
})

export class MenuPizzaService{
    constructor (private http:HttpClient){}


    URL: string = 'localhost:8084/FoodForce/food/all/';

    getQuests(): Observable<Order>{

        return this.http.get<Order>(this.URL, heetOptions);
    }
}