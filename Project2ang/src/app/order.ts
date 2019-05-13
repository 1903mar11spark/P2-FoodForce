import { Employee } from './emp-my-info/emp-info';
import { Customer } from './cust-info/cust-info';

export interface Order{

    id: number;
    status: string;
    total: number;
   //how to refenece another object in an object
     emp: Employee;
    cus: Customer
}