import {CanActivate, Router} from '@angular/router';
import {Injectable} from '@angular/core';
import {AuthService} from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private authSerivce: AuthService, private router: Router) {
  }

  canActivate() {
    if (this.authSerivce.isLoggedIn()) {
      this.router.navigate(['products']);
    }
    return !this.authSerivce.isLoggedIn();
  }

}
