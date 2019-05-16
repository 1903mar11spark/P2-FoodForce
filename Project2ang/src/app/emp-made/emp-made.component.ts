import { Component, OnInit } from '@angular/core';
import { EmpMadeService } from './emp-made.service';
import { Order } from '../order';

@Component({
  selector: 'app-emp-made',
  templateUrl: './emp-made.component.html',
  styleUrls: ['./emp-made.component.css']
})
export class EmpMadeComponent implements OnInit {

made: Order[];

  constructor(private empMadeService: EmpMadeService) { }

  ngOnInit() {

    this.empMadeService.getMade().then((response)=>{
      response.json().then((empMadeService)=>{
        this.made = empMadeService;
      });
    })
  }

  sell(i){
    //order/change/id
      let x = this.made[i].id
      return fetch('http://localhost:8084/FoodForce/order/change/'+x,{    
        method: 'PUT',
      mode: 'cors',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        status: 'Paid',
        })
      })
    
    }

}
