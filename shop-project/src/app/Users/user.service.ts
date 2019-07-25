import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Customer} from './customer';
import {User} from './new-user-window/new-user-window.component';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseUrl = 'http://localhost:8080/users';

  constructor(private http: HttpClient) {
  }

  public getCustomersList(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.baseUrl);
  }

  public changeActivity(user: Customer): Observable<Customer> {
    return this.http.put<Customer>(`${this.baseUrl}/changestate/${user.id}`, user);
  }

  public updateUser(user: Customer): Observable<Customer> {
    return this.http.put<Customer>(`${this.baseUrl}/update/${user.id}`, user);
  }

  public getRoles(): Observable<string[]> {
    return this.http.get<string[]>(`${this.baseUrl}/roles`);
  }

  public deleteUser(user: Customer): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete/${user.id}`, {responseType: 'text'});
  }

  public addUser(user: User): Observable<User> {
    return this.http.post<User>(`${this.baseUrl}/add`, user);
  }

  public changePassword(id: number, pass: string): Observable<string> {
    return this.http.put<string>(`${this.baseUrl}/changepassword/${id}`, pass);
  }
}

