import {Customer} from './customer';

export class UserParser {
  public fromJson(json: any): Customer {
    const customer = new Customer();
    customer.id = json.id;
    customer.firstname = json.firstname;
    customer.lastname = json.firstname;
    customer.login = json.login;
    customer.pass = json.pass;
    customer.role = json.role;
    return customer;
  }
}
