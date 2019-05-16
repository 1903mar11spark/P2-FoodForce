import { Component, OnInit } from '@angular/core';
import { MenuWingsService } from './menu-wings.service';
import { Menu } from '../menu';

@Component({
  selector: 'app-menu-wings',
  templateUrl: './menu-wings.component.html',
  styleUrls: ['./menu-wings.component.css']
})
export class MenuWingsComponent implements OnInit {

public wings: Menu;

  constructor(private menuWingsService: MenuWingsService) { }


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
   this.price=this.price+10.65;
  console.log(this.price)
  }
  
  public counterMinus(index):void{
    if(this.order.includes(index)){
    this.counter--;
   let where = this.order.lastIndexOf(index)
   this.order.splice(where, 1)
   this.price=this.price-10.65;
  console.log(this.price);
    }
  }
  


  ngOnInit() {

    this.menuWingsService.getQuests().then((response)=>{
      response.json().then((menuWingsService)=>{
        this.wings = menuWingsService;
      });
    })

  }

  public food: object[]=[];

  createOrder(){

 
    for(let i=0; i<this.order.length; i++){
      let x =this.order[i]+10;
        this.food.push({id: x})
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
