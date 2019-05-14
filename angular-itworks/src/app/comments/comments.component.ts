import { Component, OnInit } from '@angular/core';
import {DataService} from '../comments.service';
import {Observable} from 'rxjs';




@Component({
  selector: 'app-posts',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.css']
})
export class CommentsComponent implements OnInit {

  comments:Object;
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
  }

}
