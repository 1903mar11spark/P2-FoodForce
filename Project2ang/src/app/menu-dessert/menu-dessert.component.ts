import { Component, OnInit } from '@angular/core';
import { Menu } from '../menu';
import { MenuDessertService } from './menu-dessert.service';

@Component({
  selector: 'app-menu-dessert',
  templateUrl: './menu-dessert.component.html',
  styleUrls: ['./menu-dessert.component.css']
})
export class MenuDessertComponent implements OnInit {

index: number;

public dessert: Menu;

  constructor(private menuDessertService: MenuDessertService) { }

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
   this.price=this.price+9.55;
  console.log(this.price)
  }
  
  public counterMinus(index):void{
    if(this.order.includes(index)){
    this.counter--;
   let where = this.order.lastIndexOf(index)
   this.order.splice(where, 1)
   this.price=this.price-9.55;
  console.log(this.price);
    }
  }



  ngOnInit() {

    
    this.menuDessertService.getDesserts().then((response)=>{
      response.json().then((menuDessertService)=>{
        this.dessert = menuDessertService;
      });
    })

  }

public food: object[]=[];

  createOrder(){

 
    for(let i=0; i<this.order.length; i++){
let x = this.order[i]+30

        this.food.push({id: x })
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
