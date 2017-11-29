import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { SearchInputComponent } from './search-input/search-input.component';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import { OutputSearchDataComponent } from './output-search-data/output-search-data.component';

@NgModule({
  declarations: [
    AppComponent,
    SearchInputComponent,
    OutputSearchDataComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
