import { Component } from '@angular/core';
import {AuthService} from './Guards/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'shop-project';
  constructor(private authService: AuthService){
  }
  logoutClick() {
    this.authService.doLogoutUser();
  }
}
