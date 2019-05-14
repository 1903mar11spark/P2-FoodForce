import { Component, OnInit } from '@angular/core';
import {DataService} from '../users.service';
import {Observable} from 'rxjs';




@Component({
  selector: 'app-posts',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  users:Object;
  constructor(private data:DataService) { }

  ngOnInit() {
    //this.data.GetPosts().subscribe(

      //data => this.users = data
    //);

    this.data.GetUsers().then((response)=>{
      response.json().then((data)=>{
        this.users = data;
      });
    }).catch((err)=>{
      alert("error!");
    });
  }

}
