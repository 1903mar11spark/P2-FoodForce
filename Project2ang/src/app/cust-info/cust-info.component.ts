import { Component, OnInit } from '@angular/core';
import { Customer } from './cust-info';
import { CustInfoService } from './cust-info.service';

@Component({
  selector: 'app-cust-info',
  templateUrl: './cust-info.component.html',
  styleUrls: ['./cust-info.component.css']
})
export class CustInfoComponent implements OnInit {

cust: Customer;


  constructor(private custInfoService: CustInfoService) { }

  ngOnInit() {

    this.custInfoService.getCust().subscribe(cust => this.cust = cust);

  }

}
