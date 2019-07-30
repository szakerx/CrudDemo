import {Component, OnInit} from '@angular/core';
import {MatDialogRef} from '@angular/material';

@Component({
  selector: 'app-change-password-component',
  templateUrl: './change-password-component.component.html',
  styleUrls: ['./change-password-component.component.scss']
})
export class ChangePasswordComponentComponent implements OnInit {

  public password: string;
  public repeat: string;
  public isValid: boolean;

  constructor(public dialog: MatDialogRef<ChangePasswordComponentComponent>) {
  }

  ngOnInit() {
    this.password = '';
    this.repeat = '';
    this.isValid = false;
  }

  cancelClick() {
    this.dialog.close();
  }

  getPasswordBack() {
    if (this.password === this.repeat) {
      this.dialog.close(this.password);
    } else {
      this.isValid = true;
    }
  }

  changeState() {
    this.isValid = false;
  }
}
