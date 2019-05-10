import { Component, OnInit } from '@angular/core';
import { MenuPizzaService } from './menu-pizza.service';
import { Order } from '../order';

@Component({
  selector: 'app-menu-pizza',
  templateUrl: './menu-pizza.component.html',
  styleUrls: ['./menu-pizza.component.css']
})
export class MenuPizzaComponent implements OnInit {

  public quests: Order;


  constructor(private menuPizzaService: MenuPizzaService) { }

  ngOnInit() {
   
this.menuPizzaService.getQuests().subscribe(quests =>{
  this.quests = quests
});
console.log(this.quests);
}
}