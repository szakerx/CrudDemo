import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoggedUserService {
  private baseUrl = 'http://localhost:8080/checkuser';

  // Wstrzyknięcie httpClienta do klasy
  constructor(private http: HttpClient) {
  }

  /*Sprawdz w bazie czy dany user istnieje i to zwróc
    Użycie Promisa aby zasubskrybować i zachować asynchroniczność */
  public chceckExistance(login: string, pass: string): Promise<boolean> {
    return new Promise(resolve => {
      this.http.get(this.baseUrl + '?login=' + login + '&pass=' + pass)
        .subscribe((data: boolean) => {
          resolve(data);
        });
    });
  }
}
