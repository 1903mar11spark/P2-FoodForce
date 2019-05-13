import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

//Components
import { AppComponent } from './app.component';
import { FormsModule , ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { EmployeeMainComponent } from './employee-main/employee-main.component';
import { MyInfoComponent } from './my-info/my-info.component';
import { EmpPendingComponent } from './emp-pending/emp-pending.component';
import { EmpAcceptedComponent } from './emp-accepted/emp-accepted.component';
import { EmpMadeComponent } from './emp-made/emp-made.component';
import { EmpCompleteComponent } from './emp-complete/emp-complete.component';
import { CustomerMainComponent } from './customer-main/customer-main.component';
import { CustOrderStatusComponent } from './cust-order-status/cust-order-status.component';
import { CustOrderHistoryComponent } from './cust-order-history/cust-order-history.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { MenuPizzaComponent } from './menu-pizza/menu-pizza.component';
import { CheckOutComponent } from './check-out/check-out.component';
import {FoodAddComponent } from './food-add/food-add.component';

import { LoginFormComponent } from './login-form/login-form.component';
import { FooterComponent } from './footer/footer.component';
import { FoodDetailComponent } from './food-detail/food-detail.component';
import {
  MatInputModule,
  MatPaginatorModule,
  MatProgressSpinnerModule,
  MatSortModule,
  MatTableModule,
  MatIconModule,
  MatButtonModule,
  MatCardModule,
  MatFormFieldModule } from "@angular/material";
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

//Services

@NgModule({
  declarations: [
    AppComponent,

    LoginComponent,
    EmployeeMainComponent,
    MyInfoComponent,
    EmpPendingComponent,
    EmpAcceptedComponent,
    EmpMadeComponent,
    EmpCompleteComponent,
    CustomerMainComponent,
    CustOrderStatusComponent,
    CustOrderHistoryComponent,
    ContactUsComponent,
    MenuPizzaComponent,
    CheckOutComponent,
    LoginFormComponent,
    FooterComponent,
    FoodDetailComponent,
    FoodAddComponent
    ],

  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
    MatInputModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatProgressSpinnerModule,
    MatIconModule,
    MatButtonModule,
    MatCardModule,
    MatFormFieldModule,
    BrowserAnimationsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
