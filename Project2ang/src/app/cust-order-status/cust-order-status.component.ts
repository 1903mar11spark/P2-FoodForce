import { Component, OnInit } from '@angular/core';
import { CustomerOrderStatusService } from './cust-order-status.service';

@Component({
  selector: 'app-cust-order-status',
  templateUrl: './cust-order-status.component.html',
  styleUrls: ['./cust-order-status.component.css']
})
export class CustOrderStatusComponent implements OnInit {

  constructor(private custOrdersStatus:CustomerOrderStatusService) { }

status: object[]=[];

  ngOnInit() {
  }
  getStatus(orderId){

    fetch('http://localhost:8084/FoodForce/order/get-by-id/'+orderId)
    .then((response)=>{
      response.json().then((custOrdersStatus)=>{
        this.status = custOrdersStatus;
      });
    })
  }

}
