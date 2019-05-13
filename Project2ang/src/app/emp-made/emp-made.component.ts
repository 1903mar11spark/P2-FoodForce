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

this.empMadeService.getMade()
    .subscribe( made => this.made = made)

  }

}
