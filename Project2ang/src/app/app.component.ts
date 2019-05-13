import { Component, OnInit } from '@angular/core';
import { FoodsService } from './services/foods/foods.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Project2ang';
  foods: Array<object>;

constructor(private foodsService: FoodsService) { }

ngOnInit() {
  this.foodsService.get().subscribe(res => {
    this.foods = res;
  });
}
}

