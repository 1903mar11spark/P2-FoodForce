import { Component, OnInit, Input, NgModule } from '@angular/core';
import { MenuPizzaService } from './menu-pizza.service';
import { Menu} from '../menu';


@Component({
  selector: 'app-menu-pizza',
  templateUrl: './menu-pizza.component.html',
  styleUrls: ['./menu-pizza.component.css']
})

export class MenuPizzaComponent implements OnInit {

  @Input()
  index: number;
  
  public quests: Menu;

  constructor(private menuPizzaService: MenuPizzaService) { }

public counter=0;
public price: number =0;
public order: number [] = [];

public display = false;

public counterAdd(index): void {
  this.counter++;
  let x: number = index;
  console.log(x);
  this.order.push(x);
 this.display = true;
 this.price=this.price+8.45;
console.log(this.price)
}

public counterMinus(index):void{
  if(this.order.includes(index)){
  this.counter--;
 let where = this.order.lastIndexOf(index)
 this.order.splice(where, 1)
 this.price=this.price-8.45;
console.log(this.price);
  }
}

  ngOnInit() {
   

    this.menuPizzaService.getQuests().then((response)=>{
      response.json().then((menuPizzaService)=>{
        this.quests = menuPizzaService;
      });
    })

 console.log(this.quests);
}
public food: object[]=[];


createOrder(){

 
    for(let i=0; i<this.order.length; i++){
        this.food.push({id: this.order[i]})
  }

  fetch('http://localhost:8084/FoodForce/order/'+1,{
    method: 'POST',
    mode: 'cors',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({
      status: 'Pending',
      total: this.price,
      employee: { id: 1 },
      food:  this.food
    
      })
      
    })
  
  };
}




