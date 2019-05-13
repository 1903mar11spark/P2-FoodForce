import { Injectable } from '@angular/core';
import { Observable, of, throwError } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { catchError, tap, map } from 'rxjs/operators';
import { Food } from './food/food';

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

  constructor(private http: HttpClient) { }

  get() {
    return of(this.foods);
  }

  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
  
      // send the error to remote logging infrastructure
      console.error(error); // log to console instead
  
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
  getFoods (): Observable<Food[]> {
    return this.http.get<Food[]>(apiUrl)
      .pipe(
        tap(foodMenu => console.log('fetched products')),
        catchError(this.handleError('getProducts', []))
      );
  }
  
  getFood(id: number): Observable<Food> {
    const url = `${apiUrl}/${id}`;
    return this.http.get<Food>(url).pipe(
      tap(_ => console.log(`fetched food id=${id}`)),
      catchError(this.handleError<Food>(`getFood id=${id}`))
    );
  }
  addFood (food): Observable<Food> {
    return this.http.post<Food>(apiUrl, food, httpOptions).pipe(
      tap((food: Food) => console.log(`added pizza w/ id=${food.id}`)),
      catchError(this.handleError<Food>('addFood'))
    );
  }

}
