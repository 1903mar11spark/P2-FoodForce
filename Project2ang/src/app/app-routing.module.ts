import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent} from './login/login.component';
import { EmployeeMainComponent } from './employee-main/employee-main.component';
import { MyInfoComponent } from './my-info/my-info.component';
import { EmpCompleteComponent } from './emp-complete/emp-complete.component';
import { EmpMadeComponent } from './emp-made/emp-made.component';
import { EmpPendingComponent } from './emp-pending/emp-pending.component';
import { EmpAcceptedComponent } from './emp-accepted/emp-accepted.component';
import { CustomerMainComponent } from './customer-main/customer-main.component';
import { CustOrderStatusComponent } from './cust-order-status/cust-order-status.component';
import { CustOrderHistoryComponent } from './cust-order-history/cust-order-history.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { MenuPizzaComponent } from './menu-pizza/menu-pizza.component';
import { CheckOutComponent } from './check-out/check-out.component';


const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'customer', component: CustomerMainComponent,
  children: [
    {path: 'info', component: MyInfoComponent},
    {path: 'status', component: CustOrderStatusComponent},
    {path: 'history', component: CustOrderHistoryComponent},
    {path: 'contactUs', component: ContactUsComponent},
    {path: 'menu',
      children:[
        {path: 'pizza', component: MenuPizzaComponent},
      ]},
    {path: 'checkOut', component: CheckOutComponent}
    ]},
  {path: 'employee', component: EmployeeMainComponent,
  children: [
  
    {path: 'complete', component: EmpCompleteComponent},
    {path: 'made', component: EmpMadeComponent},
    {path: 'info', component: MyInfoComponent},
    {path: 'pending', component: EmpPendingComponent},
    {path: 'accepted', component: EmpAcceptedComponent}
    
  ]
}
]

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})

export class AppRoutingModule {}

//this is for telling the code where to go when something is clicked