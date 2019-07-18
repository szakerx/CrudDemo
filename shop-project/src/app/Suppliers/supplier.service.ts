import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Supplier} from './Supplier';

@Injectable({
  providedIn: 'root'
})
export class SupplierService {

  private baseUrl = 'http://localhost:8080/suppliers';

  constructor(private http: HttpClient) {
  }

  public getAllSuppliers(): Observable<Supplier[]> {
    return this.http.get<Supplier[]>(this.baseUrl);
  }
}
