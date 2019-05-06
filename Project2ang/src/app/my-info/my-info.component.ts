import { Component, OnInit } from '@angular/core';
import {Order} from '../order';
import {ORDERS} from '../test-orders';


@Component({
  selector: 'app-my-info',
  templateUrl: './my-info.component.html',
  styleUrls: ['./my-info.component.css']
})
export class MyInfoComponent implements OnInit {
orders=ORDERS;
  constructor() { }

  ngOnInit() {
  }



}
