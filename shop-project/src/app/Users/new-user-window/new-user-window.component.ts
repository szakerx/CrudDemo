import {Component, Inject, OnInit} from '@angular/core';
import {UserService} from '../user.service';
import {MatDialog, MatDialogRef} from '@angular/material';

export class User {
  constructor(private id: number = -1, public firstname: string = '', public lastname: string = '',
              public login: string = '', public pass: string = '', public role: string = '',
              public active: boolean = false) {
  }
  canBeReturned(): boolean {
    if (this.firstname === '' || this.lastname === '' ||
      this.login === '' || this.pass === '' ||
      this.role === '') {
      return false;
    } else {
      return true;
    }
  }
}

@Component({
  selector: 'app-new-user-window',
  templateUrl: './new-user-window.component.html',
  styleUrls: ['./new-user-window.component.scss']
})
export class NewUserWindowComponent implements OnInit {

  constructor(private userService: UserService, private dialog: MatDialogRef<NewUserWindowComponent>) {
  }

  public user: User;
  roles: string[];
  isUnvalid = false;

  ngOnInit() {
    this.user = new User();
    this.loadRoles();
  }

  loadRoles() {
    this.userService.getRoles().subscribe(data => {
      this.roles = data;
    });
  }

  cancelClick() {
    this.dialog.close();
  }

  returnUser() {
    if (this.user.canBeReturned()) {
      this.dialog.close(this.user);
    } else {
      this.isUnvalid = true;
    }
  }
}
