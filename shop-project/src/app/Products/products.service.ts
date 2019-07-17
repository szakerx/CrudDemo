import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from './product';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {
  private baseUrl = 'http://localhost:8080/products';

  // Wstrzyknięcie httpClienta
  constructor(private http: HttpClient) {
  }

  // Pobierz z bazy wszystkie produkty
  public getAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.baseUrl);
  }
  // Pobierz z bazy wszystkie typy produktow
  public getAllTypes(): Observable<string[]> {
    return this.http.get<string[]>(`${this.baseUrl}/enums/types`);
  }

  // Pobierz z bazy wszystkie kategorie produktow
  public getAllCategories(): Observable<string[]> {
    return this.http.get<string[]>(`${this.baseUrl}/enums/categories`);
  }

  public getAllSupplierNames(): Observable<string[]> {
    return this.http.get<string[]>('http://localhost:8080/suppliers/names');
  }

  public addProduct(product: Product): Observable<Product> {
    return this.http.post<Product>(`${this.baseUrl}/add`, product);
  }
}
