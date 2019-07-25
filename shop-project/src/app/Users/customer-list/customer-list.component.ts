import {Component, OnInit, ViewChild} from '@angular/core';
import {UserService} from '../user.service';
import {Customer} from '../customer';
import {MatDialog, MatTableDataSource} from '@angular/material';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {UserWindowComponent} from '../user-window/user-window.component';
import {ConfirmDialogComponent} from '../../confirm-dialog/confirm-dialog.component';
import {NewUserWindowComponent} from '../new-user-window/new-user-window.component';
import {ChangePasswordComponentComponent} from '../change-password-component/change-password-component.component';

@Component({
  selector: 'customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.scss']
})
export class CustomerListComponent implements OnInit {

  customers: Customer[];
  columnsToDisplay: string[] = ['id', 'firstname', 'lastname', 'login', 'role', 'isactive', 'changepass', 'edit', 'delete'];
  dataSource: MatTableDataSource<Customer>;


  constructor(private customerService: UserService, private dialog: MatDialog) {
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

  changeState(user: Customer) {
    if (user.active) {
      user.active = false;
    } else {
      user.active = true;
    }
    this.customerService.changeActivity(user).subscribe(() => {
      this.reloadData();
    });
  }

  editButtonClick(user: Customer) {
    const dialogRef = this.dialog.open(UserWindowComponent, {
      width: '800px',
      data: user
    });

    dialogRef.afterClosed().subscribe(backUser => {
      if (backUser) {
        this.customerService.updateUser(backUser).subscribe(() => {
          this.reloadData();
        });
      }
    });
  }

  deleteButtonClick(user: Customer) {
    const dialogConfirm = this.dialog.open(ConfirmDialogComponent, {
      width: '300px',
      data: user.firstname
    });

    dialogConfirm.afterClosed().subscribe(confirm => {
      if (confirm) {
        this.customerService.deleteUser(user).subscribe(info => {
          this.reloadData();
        });
      }
    });
  }

  addButtonClick() {
    const dialogRef = this.dialog.open(NewUserWindowComponent, {
      width: '450px',
      data: new Customer()
    });

    dialogRef.afterClosed().subscribe(backUser => {
      if (backUser) {
        this.customerService.addUser(backUser).subscribe(() => {
          this.reloadData();
        });
      }
    });
  }

  changePassword(user: Customer) {
    const dialogRef = this.dialog.open(ChangePasswordComponentComponent, {
      width: '450px',
    });

    dialogRef.afterClosed().subscribe(data => {
      if (data) {
        this.customerService.changePassword(user.id, data).subscribe(() => {
          console.log('changed');
        });
      }
    });
  }
}
