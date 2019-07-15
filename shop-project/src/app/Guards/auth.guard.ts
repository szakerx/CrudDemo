import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree} from '@angular/router';
import {Observable} from 'rxjs';
import {Injectable} from '@angular/core';

@Injectable
export class AuthGuard implements CanActivate{

  constructor(private authSerive: AuthService, private router: Router){

  }
  canActivate(route: ActivatedRouteSnapshot,
              state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

    this.authSerive.authInfo$
      .map(authInfo => authInfo.isLoggedin())
      .take(1);
    
    return undefined;
  }

}
