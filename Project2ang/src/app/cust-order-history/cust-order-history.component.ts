import { Component, OnInit } from '@angular/core';
import { CustomerOrderHistoryService } from './cust-order-history.service';

@Component({
  selector: 'app-cust-order-history',
  templateUrl: './cust-order-history.component.html',
  styleUrls: ['./cust-order-history.component.css']
})
export class CustOrderHistoryComponent implements OnInit {

  constructor(private customerOrderHistoryService: CustomerOrderHistoryService) { }

history: object[]=[];





  ngOnInit() {
  }
  getHist(userId){
    
      fetch('http://localhost:8084/FoodForce/order/'+userId)
    

  }

}
