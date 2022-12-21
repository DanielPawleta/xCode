import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { NumbersDTO } from './numbersDTO';
import { SortedNumbersDTO } from './sortedNumbersDTO';
import { SortService } from './sort.service';
import { CurrencyCodeDTO } from './currencyCodeDTO';
import { CurrencyValueDTO } from './currencyValueDTO';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  public pong:string='';
  public isDisabledPing: boolean = false;

  public numbersFromUser: number [] = [];
  public onlyNumbersPlease:string ='';
  public numbersDTO: NumbersDTO = {order: "ASC", numbers: []};
  public sortedNumbersDTO: SortedNumbersDTO = {numbers:[]};

  public currencyCodeDTO: CurrencyCodeDTO = {currency:''}
  public wrongCodeWarn:string = '';
  public currencyValueDTO: CurrencyValueDTO = {value: 1}
  public isCurrencyValueLoaded: boolean = false;

  public ascendingButtonColor: string ='primary';
  public descendingButtonColor: string ='';
  
  constructor(private sortService: SortService) { }

  public getPong(){
    this.sortService.getPong().subscribe(
      (response: string) => {
        this.pong=response;
      },
      (error: HttpErrorResponse) =>
      alert(error.message)
    )
  }

  public onClickPing(){
    this.isDisabledPing=true;
    this.getPong()
  }

  public onClickAdd(numberAsString: string){
    if (!isNaN(Number(numberAsString))){
      this.onlyNumbersPlease=""
      this.numbersFromUser.push( Number(numberAsString))
      this.numbersDTO.numbers=this.numbersFromUser;
      }
      else
       {
       this.onlyNumbersPlease="Type only numbers please"
       }
  }

  public onClickSort(){
    this.updateArrayFromServer()
  }

  public onClickAscending(){
    this.ascendingButtonColor="primary"
    this.descendingButtonColor=''
    this.numbersDTO.order="ASC";
  }

  public onClickDescending(){
    this.descendingButtonColor="primary";
    this.ascendingButtonColor=''
    this.numbersDTO.order="DESC";
  }

  public updateArrayFromServer(){
    this.sortService.getSortedNumbers(this.numbersDTO).subscribe(
      (response: any) => {
        this.sortedNumbersDTO = response;
      }
    )
  }

  public onClickGetCurrencyValue(currencyCodeFromUser: string){
    this.isCurrencyValueLoaded=false;
    if (currencyCodeFromUser.length!=3 || currencyCodeFromUser.toUpperCase() != currencyCodeFromUser){
      this.wrongCodeWarn="Type only 3 upper case letter code please"
    }
    else{
      this.wrongCodeWarn='';
      this.currencyCodeDTO.currency = currencyCodeFromUser;
      this.updateCurrencyValueFromServer()
    }
  }

  public updateCurrencyValueFromServer(){
    this.sortService.getCurrencyValue(this.currencyCodeDTO).subscribe(
      (response: any) => {
        this.currencyValueDTO = response;
      }
    )
    this.isCurrencyValueLoaded=true;
  }
}