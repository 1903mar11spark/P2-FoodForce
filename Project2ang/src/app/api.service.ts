import { Injectable } from '@angular/core';
import { Observable, of, throwError } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { catchError, tap, map } from 'rxjs/operators';
import { Food } from './food';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};
const apiUrl = "/api/food";

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  foods: Array<object> = [
    {id: 1, description: 'Pizza with four cheeses', name: 'Cheese Pizza', type: 'Pizza' },
    {id: 2, description: 'Pizza with four meats', name: 'Meat Pizza', type: 'Pizza' },
    {id: 3, description: 'Pizza with four veggies', name: 'Veggie Pizza', type: 'Pizza' },
    {id: 4, description: 'Pizza with four fruits', name: 'Fruit Pizza', type: 'Pizza' },  
    {id: 5, description: 'Pizza with four sauces', name: 'Sauce Pizza', type: 'Pizza' },
  ];

  constructor() { }

  get() {
    return of(this.foods);
  }

}
