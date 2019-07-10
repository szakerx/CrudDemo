import { CustomerListComponent } from '../customer-list/customer-list.component';
import { Component, OnInit, Input } from '@angular/core';
import {Customer} from '../customer';
import {UserService} from '../user.service';

@Component({
  selector: 'customer-details',
  templateUrl: './customer-details.component.html',
  styleUrls: ['./customer-details.component.scss']
})
export class CustomerDetailsComponent implements OnInit {

  @Input() customer: Customer;
  constructor(private customerService: UserService, private listComponent: CustomerListComponent) { }

  ngOnInit() {
  }
}
