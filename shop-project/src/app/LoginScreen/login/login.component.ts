import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {MatDialog} from '@angular/material';
import {LoggedUserService} from '../logged-user/logged-user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  constructor(private router: Router, private service: LoggedUserService) {
  }

  username: string;
  password: string;

  ngOnInit() {
  }

  login(): void {
    let check: boolean;
    this.service.chceckExistance(this.username, this.password).then((data: boolean) => {
      check = data;
      if (check) {
        // Coś z base auth ale jeszcze się uczę
      } else {
        alert('Invalid login or password!');
      }
    });
  }
}
