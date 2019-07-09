import {Component, NgIterable, OnInit} from '@angular/core';
import {Observable} from 'rxjs';

import {UserService} from '../user.service';
import {Customer} from '../customer';

@Component({
  selector: 'customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.scss']
})
export class CustomerListComponent implements OnInit {

  customers: Observable<Customer[]>;

  constructor(private customerService: UserService) {
  }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.customers = this.customerService.getCustomersList();
  }

}
