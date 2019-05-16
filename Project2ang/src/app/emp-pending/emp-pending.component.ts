import { Component, OnInit } from '@angular/core';
import { EmpPendingService } from './emp-pending.service';
import { Order } from '../order';

@Component({
  selector: 'app-emp-pending',
  templateUrl: './emp-pending.component.html',
  styleUrls: ['./emp-pending.component.css']
})
export class EmpPendingComponent implements OnInit {

pends: Order[];

  constructor(private empPendingService: EmpPendingService) { }

  ngOnInit() {   

    this.empPendingService.getPend().then((response)=>{
      response.json().then((empPendingService)=>{
        this.pends = empPendingService;
      });
    })

 console.log(this.pends);
}

accept(i){
//order/change/id
  let x = this.pends[i].id
  return fetch('http://localhost:8084/FoodForce/order/change/'+x,{    
    method: 'PUT',
  mode: 'cors',
  headers: {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
  },
  body: JSON.stringify({
    status: 'Accepted',
    //total: this.price,
    //employee: { id: 1 },
   // food:  this.food
  
    })
    
  })

}
}
