import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';



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

export class MenuDessertService{
    constructor (private http:HttpClient){}


    URL: string = 'localhost:8084/FoodForce/food/all/';

    getDesserts(){
 
        return fetch('http://localhost:8084/FoodForce/food/get-by-type/Dessert');

    }


}