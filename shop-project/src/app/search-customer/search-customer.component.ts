import { UserService } from './../user.service';
import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
@Component({
  selector: 'search-customer',
  templateUrl: './search-customer.component.html',
  styleUrls: ['./search-customer.component.scss']
})
export class SearchCustomerComponent implements OnInit {
  age: number;
  customers: Customer[];

  constructor(private dataService: UserService) { }

  ngOnInit() {
    this.age = 0;
  }
  private searchCustomers() {
    this.dataService.getCustomersByAge(this.age)
      .subscribe(customers => this.customers = customers);
  }
 
  onSubmit() {
    this.searchCustomers();
  }

}
