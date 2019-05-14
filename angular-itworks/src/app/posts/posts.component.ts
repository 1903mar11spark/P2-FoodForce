import { Component, OnInit } from '@angular/core';
import {DataService} from '../data.service';
import {Observable} from 'rxjs';




@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent implements OnInit {

  posts:Object;
  constructor(private data:DataService) { }

  ngOnInit() {
    //this.data.GetPosts().subscribe(

      //data => this.posts = data
    //);

    this.data.GetPosts().then((response)=>{
      response.json().then((data)=>{
        this.posts = data;
      });
    }).catch((err)=>{
      alert("error!");
    });
  }

}
