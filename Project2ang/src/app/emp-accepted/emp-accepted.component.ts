import { Component, OnInit } from '@angular/core';
import { runInThisContext } from 'vm';
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
    this.empAcceptedService.getAccepted().
    subscribe(acc => this.acc = acc)
  }

}
