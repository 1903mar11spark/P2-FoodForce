import { Component, OnInit } from '@angular/core';
import { MenuPizzaService } from './menu-pizza.service';
import { Menu} from '../menu';

@Component({
  selector: 'app-menu-pizza',
  templateUrl: './menu-pizza.component.html',
  styleUrls: ['./menu-pizza.component.css']
})
export class MenuPizzaComponent implements OnInit {

  public quests: Menu;

  pizza: Menu[];

  constructor(private menuPizzaService: MenuPizzaService) { }

  ngOnInit() {
   
//this.menuPizzaService.getPiz().subscribe(pizza => this.pizza = pizza);

this.menuPizzaService.getQuests().subscribe(pizza =>{
  this.pizza = pizza
});
// console.log(this.quests);
}
}