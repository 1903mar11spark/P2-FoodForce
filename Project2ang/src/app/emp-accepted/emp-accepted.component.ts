import { Component, OnInit } from '@angular/core';
import { Order } from '../order';
import { EmpAcceptService } from './emp-accepted.service';

@Component({
  selector: 'app-emp-accepted',
  templateUrl: './emp-accepted.component.html',
  styleUrls: ['./emp-accepted.component.css']
})
export class EmpAcceptedComponent implements OnInit {

acc: Order[];

  constructor(private empAcceptedService: EmpAcceptService) { }

  ngOnInit() {
   
    this.empAcceptedService.getAcc().then((response)=>{
      response.json().then((empAcceptedService)=>{
        this.acc = empAcceptedService;
      });
    })
  }

  finish(i){
    //order/change/id
      let x = this.acc[i].id
      return fetch('http://localhost:8084/FoodForce/order/change/'+x,{    
        method: 'PUT',
      mode: 'cors',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        status: 'Complete',
    
      
        })
        
      })
    
    }

}
