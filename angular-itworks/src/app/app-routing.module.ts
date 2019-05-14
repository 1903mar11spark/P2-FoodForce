import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PostsComponent } from './posts/posts.component';
import { CommentsComponent } from './comments/comments.component';
import { UsersComponent } from './users/users.component';



//const routes: Routes = [
//{
 //path:'posts',
  //component: PostsComponent,
  //path:'page1',
  //component: Page1Component,
  //path:'page2',
  //component: Page2Component

  //{ path: 'posts', component: PostsComponent },
  //{ path: 'comments', component: CommentsComponent },
  //{ path: 'users', component: UsersComponent }
//}
//];

const routes: Routes = [
  { path: 'posts', component: PostsComponent },
  { path: 'comments', component: CommentsComponent },
  { path: 'users', component: UsersComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }


