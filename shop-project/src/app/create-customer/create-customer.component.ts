import { Component, OnInit } from '@angular/core';

import { Customer } from '../customer';
import { UserService } from '../user.service';
@Component({
  selector: 'create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.scss']
})
export class CreateCustomerComponent implements OnInit {
  customer: Customer = new Customer();
  submitted = false;
  constructor(private customerService: UserService) { }

  ngOnInit() {
  }

  newCustomer(): void {
    this.submitted = false;
    this.customer = new Customer();
  }
 
  save() {
    this.customerService.createCustomer(this.customer)
      .subscribe(data => console.log(data), error => console.log(error));
    this.customer = new Customer();
  }
 
  onSubmit() {
    this.submitted = true;
    this.save();
  }


}
