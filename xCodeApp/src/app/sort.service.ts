import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { NumbersDTO } from './numbersDTO';
import { SortedNumbersDTO } from './sortedNumbersDTO';


@Injectable({
  providedIn: 'root'
})
export class SortService {
  public responseNumbers: any;

  constructor(private http: HttpClient) { }

  public getPong()  {
    return this.http.get('http://localhost:8080/status/ping', {responseType: 'text'})
  }

  //this works but after 2nd click
  public getSortedNumbers(numbersDTO: NumbersDTO)  {
    const headers = { 'content-type': 'application/json'} 

    this.http.post<SortedNumbersDTO>('http://localhost:8080/numbers/sort-command',numbersDTO)
    .subscribe( (object: SortedNumbersDTO) => {
      this.responseNumbers = object;
    });
    return this.responseNumbers
  }
}