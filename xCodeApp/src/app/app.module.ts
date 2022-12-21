import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MatButtonModule} from '@angular/material/button';


import { AppComponent } from './app.component';
import { SortService } from './sort.service';


const MaterialComponents = [
  MatButtonModule,
  
];

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    MaterialComponents,
    BrowserModule,
    HttpClientModule
  ],
  providers: [
    SortService],
  bootstrap: [AppComponent]
})
export class AppModule { }
