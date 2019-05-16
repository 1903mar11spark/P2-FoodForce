import { Component, OnInit } from '@angular/core';
import { CustInfoService } from './cust-info.service';

@Component({
  selector: 'app-cust-info',
  templateUrl: './cust-info.component.html',
  styleUrls: ['./cust-info.component.css']
})
export class CustInfoComponent implements OnInit {


  cust: object;


  constructor(private custInfoService: CustInfoService) { }

  ngOnInit() {


};

getInfo(userId){

fetch('http://localhost:8084/FoodForce/employee/'+userId)
.then((response)=>{response.json().then((custInfoService)=>{
      this.cust = custInfoService;
    });
  
  
    })
}
}