import { Injectable } from '@angular/core';
import { of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class FoodsService {

  foods: Array<object> = [
    {id: 1, description: 'Pizza with four cheeses', name: 'Cheese Pizza', type: 'Pizza' },
    {id: 2, description: 'Pizza with four meats', name: 'Meat Pizza', type: 'Pizza' },
    {id: 3, description: 'Pizza with four veggies', name: 'Veggie Pizza', type: 'Pizza' },
    {id: 4, description: 'Pizza with four fruits', name: 'Fruit Pizza', type: 'Pizza' },  
    {id: 5, description: 'Pizza with four sauces', name: 'Sauce Pizza', type: 'Pizza' },
    {id: 6, description: 'Pizza with four nothings', name: 'Nothing Pizza', type: 'Pizza' },
  ];

  constructor() { }

get() {
  return of(this.foods);
}

}
