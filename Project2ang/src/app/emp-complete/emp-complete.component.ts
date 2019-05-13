import { Component, OnInit } from '@angular/core';
import { EmpCompleteService } from './emp-complete.service';
import { Order } from '../order';

@Component({
  selector: 'app-emp-complete',
  templateUrl: './emp-complete.component.html',
  styleUrls: ['./emp-complete.component.css']
})
export class EmpCompleteComponent implements OnInit {

comp: Order[];

  constructor(private empCompleteService: EmpCompleteService) { }

  ngOnInit() {

    this.empCompleteService.getComp()
      .subscribe(comp => this.comp = comp)
  }

}
