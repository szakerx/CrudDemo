import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {catchError, map, mapTo, tap} from 'rxjs/operators';
import {Token} from './Token';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private readonly baseUrl = 'http://localhost:8080';
  private readonly JWT_TOKEN = 'JWT_TOKEN';
  // private readonly REFRESH_TOKEN = 'REFRESH_TOKEN';
  private loggedUser: string;

  constructor(private http: HttpClient) {
  }

  login(user: { username: string, password: string }): Observable<boolean> {
    return this.http.post<any>(`${this.baseUrl}/login`, user)
      .pipe(
        tap(token => {
          this.doLoginUser(user.username, token);
        }),
        mapTo(true),
        catchError(error => {
          if (error instanceof HttpErrorResponse && error.status === 401) {
            alert('Niepoprawne dane logowania');
          }
          return of(false);
        }));
  }

  // login(user: { username: string, password: string }): Observable<string> {
  //   return this.http.post<any>(`${this.baseUrl}/login`, user,
  //     // {
  //     //   headers: new HttpHeaders()
  //     //     .set('Content-Type', 'application/json'),
  //     //   observe: 'response'
  //     // }
  //   ).pipe(map(
  //     res => {
  //       const myheader = res.headers.get('Authentication');
  //       console.log(myheader);
  //       return myheader;
  //     }
  //   ));
  // }


  // logout() {
  //   return this.http.post<any>(`${this.baseUrl}/logout`, {
  //     refreshToken: this.getRefreshToken()
  //   }).pipe(
  //     tap(() => this.doLogoutUser()),
  //     mapTo(true),
  //     catchError(error => {
  //       alert(error.error);
  //       return of(false);
  //     }));
  // }

  isLoggedIn() {
    return !!this.getJwtToken();
  }

  // refreshToken() {
  //   return this.http.post<any>(`${this.baseUrl}/refresh`, {
  //     refreshToken: this.getRefreshToken()
  //   }).pipe(tap((tokens: Tokens) => {
  //     this.storeJwtToken(tokens.jwt);
  //   }));
  // }

  getJwtToken() {
    return localStorage.getItem(this.JWT_TOKEN);
  }

  getRole() {
    return localStorage.getItem('ROLE');
  }

  private doLoginUser(username: string, token: Token) {
    this.loggedUser = username;
    this.storeTokens(token);
  }

  doLogoutUser() {
    this.loggedUser = null;
    this.removeTokens();
  }

  // private getRefreshToken() {
  //   return localStorage.getItem(this.REFRESH_TOKEN);
  // }

  private storeJwtToken(jwt: string) {
    localStorage.setItem(this.JWT_TOKEN, jwt);
  }

  private storeTokens(token: Token) {
    localStorage.setItem(this.JWT_TOKEN, token.jwt);
    localStorage.setItem('ROLE', token.role);
  }

  private removeTokens() {
    localStorage.removeItem(this.JWT_TOKEN);
    // localStorage.removeItem(this.REFRESH_TOKEN);
  }
}
