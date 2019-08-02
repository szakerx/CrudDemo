import {Component} from '@angular/core';
import {AuthService} from './Guards/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

export class AppComponent {
  title = 'shop-project';
  page: any = Page;

  constructor(public authService: AuthService) {
    this.page = Page.Products;
  }

  logoutClick() {
    this.authService.doLogoutUser();
    window.location.reload();
  }

  changeEnum(x: string) {
    switch (x) {
      case 'products': {
        this.page = Page.Products;
        break;
      }
      case 'users': {
        this.page = Page.Users;
        break;
      }
      default: {
        return;
      }
    }
  }
}

enum Page {
  Products,
  Users
}


