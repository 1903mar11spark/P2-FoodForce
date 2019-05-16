import { Component, OnInit } from '@angular/core';


import { EmpInfoService } from './emp-info.service';



@Component({
  selector: 'app-my-info',
  templateUrl: './my-info.component.html',
  styleUrls: ['./my-info.component.css']
})
export class MyInfoComponent implements OnInit {


empls: object;


  constructor(private empInfoService: EmpInfoService) { }

  ngOnInit() {


};

getInfo(userId){

fetch('http://localhost:8084/FoodForce/employee/'+userId)
.then((response)=>{response.json().then((empInfoService)=>{
      this.empls = empInfoService;
    });
  
  
    })
}
}
