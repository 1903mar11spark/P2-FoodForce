import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { Food } from '../food';

@Component({
  selector: 'app-menu-pizza',
  templateUrl: './menu-pizza.component.html',
  styleUrls: ['./menu-pizza.component.css']
})
export class MenuPizzaComponent implements OnInit {

  displayedColumns: string[] = ['food_name', 'food_desc'];
  data: Food[] = [];
  isLoadingResults = true;

  constructor(private api: ApiService) { }

  ngOnInit() {
    this.api.getFoods()
    .subscribe(res => {
      this.data = res;
      console.log(this.data);
      this.isLoadingResults = false;
    }, err => {
      console.log(err);
      this.isLoadingResults = false;
    });

  }

}
