import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NumbersDTO } from './numbersDTO';
import { SortedNumbersDTO } from './sortedNumbersDTO';
import { SortService } from './sort.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  public pong:string='';
  public arrayBigDecimal: number[]=[];
  public onClickString: string ='';
  public numbersFromUser: number [] = [];
  public onlyNumbersPlease:string ='';
  public numbersDTO: NumbersDTO = {order: "ASC", numbers: [2,4]};
  public sortedNumbersDTO: SortedNumbersDTO = {numbers:[8,1]};
  public sortedNumbersArray: number[]=[2,1];
  public numberValue:number=0;
  
  constructor(private sortService: SortService) { }

  public getPong():void{
    this.sortService.getPong().subscribe(
      (response: string) => {
        this.pong=response;
      },
      (error: HttpErrorResponse) =>
      alert(error.message)
    )
  }

  public onClickPing(){
    this.getPong()
  }

  public onClickAdd(numberAsString: string){
    this.getValue(numberAsString)
  }

  public getValue(numberAsString: string){
    if (!isNaN(Number(numberAsString))){
    this.onlyNumbersPlease=""
    this.numberValue = Number(numberAsString)
    this.numbersFromUser.push(this.numberValue)
    }
    else
     {
     this.onlyNumbersPlease="Type only numbers please"
     }
  }

  public onClickSort(){
    this.numbersDTO.numbers=this.numbersFromUser;
    this.sortedNumbersDTO = {numbers: []}
    this.sortedNumbersDTO =
    this.sortService.getSortedNumbers(this.numbersDTO);
    this.sortedNumbersArray = this.sortedNumbersDTO.numbers
  }
}
