import { Credentials } from 'crypto';

export interface Employee{
    employees: [];
    id: number;
    firstName: string;
    lastName: string;
    reportsTo: number;
    credentials: Credentials;
}