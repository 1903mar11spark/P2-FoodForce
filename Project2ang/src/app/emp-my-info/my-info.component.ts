import { Component, OnInit } from '@angular/core';

import { Employee } from './emp-info';
import { EmpInfoService } from './emp-info.service';



@Component({
  selector: 'app-my-info',
  templateUrl: './my-info.component.html',
  styleUrls: ['./my-info.component.css']
})
export class MyInfoComponent implements OnInit {


empls: Employee;

public emps: Employee;

  constructor(private empInfoService: EmpInfoService) { }

  ngOnInit() {

this.empInfoService.getEm()
.subscribe(empls => this.empls = empls);

    // this .empInfoService.getEmps().subscribe(emps =>{
    //   this.emps=emps
    // });

  }



}
