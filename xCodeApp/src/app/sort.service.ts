import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { NumbersDTO } from './numbersDTO';
import { SortedNumbersDTO } from './sortedNumbersDTO';
import { CurrencyCodeDTO } from './currencyCodeDTO';
import { CurrencyValueDTO } from './currencyValueDTO';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class SortService {
  constructor(private http: HttpClient) { }

  public getPong()  {
    return this.http.get('http://localhost:8080/status/ping', {responseType: 'text'})
  }

  public getSortedNumbers(numbersDTO: NumbersDTO): Observable<any>  {
    return this.http.post<SortedNumbersDTO>('http://localhost:8080/numbers/sort-command',numbersDTO)
  }

  public getCurrencyValue(currencyCodeDTO: CurrencyCodeDTO): Observable<any>  {
    return this.http.post<CurrencyValueDTO>('http://localhost:8080/currencies/get-current-currency-value-command',currencyCodeDTO)
  }
}