import { Component, OnInit } from '@angular/core';
import { EmpPendingService } from './emp-pending.service';
import { Order } from '../order';

@Component({
  selector: 'app-emp-pending',
  templateUrl: './emp-pending.component.html',
  styleUrls: ['./emp-pending.component.css']
})
export class EmpPendingComponent implements OnInit {

pends: Order[];

  constructor(private empPendingService: EmpPendingService) { }

  ngOnInit() {   

    this.empPendingService.getPend().then((response)=>{
      response.json().then((empPendingService)=>{
        this.pends = empPendingService;
      });
    })

 console.log(this.pends);
}

}
