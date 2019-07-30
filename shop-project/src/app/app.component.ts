import { Component } from '@angular/core';
import {AuthService} from './Guards/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'shop-project';
  myboolean = true;
  constructor(public authService: AuthService){
  }
  logoutClick() {
    this.authService.doLogoutUser();
    window.location.reload();
  }

  changeBool() {
    this.myboolean = !this.myboolean;
  }
}
