import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {Customer} from '../customer';
import {ProductsService} from '../../Products/products.service';
import {UserService} from '../user.service';

@Component({
  selector: 'app-user-window',
  templateUrl: './user-window.component.html',
  styleUrls: ['./user-window.component.scss']
})
export class UserWindowComponent implements OnInit {
  roles: string[];

  constructor(private dialogRef: MatDialogRef<UserWindowComponent>,
              @Inject (MAT_DIALOG_DATA) private user: Customer,
              private userService: UserService) { }

  ngOnInit() {
    this.LoadRoles();
  }

  LoadRoles() {
    this.userService.getRoles().subscribe(data => {
      this.roles = data;
    });
  }

  cancelClick() {
    this.dialogRef.close();
  }


}
