import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Customer} from './customer';

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
}

