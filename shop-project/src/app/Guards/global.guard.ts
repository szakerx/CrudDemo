import {CanActivate, CanLoad, Router} from '@angular/router';
import {AuthService} from './auth.service';
import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class GlobalGuard implements CanActivate{

  constructor(private  authService: AuthService, private router: Router) {
  }

  canActivate() {
    if (!this.authService.isLoggedIn()) {
      this.router.navigate(['login']);
    }
    return this.authService.isLoggedIn();
  }
}
