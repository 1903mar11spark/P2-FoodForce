import { Component, OnInit } from '@angular/core';
import {DataService} from '../comments.service';
import {Observable} from 'rxjs';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-posts',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.css']
})
export class CommentsComponent implements OnInit {

  comments:Object;
  customerid: number = 1;
  status: string = "pending";
  price: number = 10;
  employeeid: number = 1;
  menu: Array<Object> = [];
  selectedItem: Object = null;

  constructor(private data:DataService) { }

  ngOnInit() {
    //this.data.GetPosts().subscribe(

      //data => this.comments = data
    //);

    this.data.GetComments().then((response)=>{
      response.json().then((data)=>{
        this.comments = data;
      });
    }).catch((err)=>{
      alert("error!");
    });

    fetch("http://localhost:8084/FoodForce/food/all").then((response)=>{
      response.json().then((data)=>{
        this.menu = data;
      })
    })
  }

  cancel(orderId) {
    const fetchParams:RequestInit = {
      method: 'DELETE',
      mode: 'cors'
    }
    fetch('http://localhost:8084/FoodForce/order/'+orderId, fetchParams)
    .then((response)=> {
      //refreash page, route to same page
    })
  }

    createOrder(){

      fetch('http://localhost:8084/FoodForce/order/'+this.customerid,{
        method: 'POST',
        mode: 'cors',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          status: this.status,
          total: this.price,
          employee: { id: this.employeeid },
          food: [{id: this.selectedItem.id}]
        })
      });
    }

}
