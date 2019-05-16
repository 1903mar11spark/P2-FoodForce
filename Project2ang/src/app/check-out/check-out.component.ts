import { Component, OnInit, NgModule } from '@angular/core';
import { MenuPizzaComponent } from '../menu-pizza/menu-pizza.component';

@Component({
  selector: 'app-check-out',
  templateUrl: './check-out.component.html',
  styleUrls: ['./check-out.component.css']
})


export class CheckOutComponent implements OnInit {

  constructor(public menuPizzaComponent: MenuPizzaComponent) { }


  ngOnInit() {
  console.log(  this.menuPizzaComponent.counter )
    
// let items: number= this.menuPizzaComponent.order.length;
// console.log(items);
// let total: number= items*8.45;

// console.log(total);
  }

}
