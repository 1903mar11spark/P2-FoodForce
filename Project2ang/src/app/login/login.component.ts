import { Component, OnInit , Injectable} from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { HttpHeaders, HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
@Injectable({
    providedIn: 'root'
})
export class LoginComponent implements OnInit {

  // base_uri = 'http://localhost:8084/FoodForce'

  // loginInfo: any = {};
  // angForm: FormGroup;

  // constructor(private fb: FormBuilder, private http:HttpClient) {
  //   this.createForm();
  // }

  // createForm() {
  //   this.angForm = this.fb.group({
  //     username: ['', Validators.required ],
  //     password: ['', Validators.required ]
  //   });
  // }

   ngOnInit() {

   }

  // doLogin(username, password) {
  //   const loginObj = {
  //     username: username,
  //     password: password
  //   }

  //    this.http.post(`${this.base_uri}/login`, loginObj)

  // }

}
