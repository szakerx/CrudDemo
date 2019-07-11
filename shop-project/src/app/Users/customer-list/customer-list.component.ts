import {Component, OnInit, ViewChild} from '@angular/core';
import {UserService} from '../user.service';
import {Customer} from '../customer';
import {MatTableDataSource} from '@angular/material';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';

@Component({
  selector: 'customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.scss']
})
export class CustomerListComponent implements OnInit {

  customers: Customer[];
  columnsToDisplay: string[] = ['id', 'firstname', 'lastname', 'edit', 'delete'];
  dataSource: MatTableDataSource<Customer>;


  constructor(private customerService: UserService) {
  }

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.customerService.getCustomersList().subscribe(data => {
      this.customers = data;
      this.dataSource = new MatTableDataSource<Customer>(this.customers);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });

  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
}
