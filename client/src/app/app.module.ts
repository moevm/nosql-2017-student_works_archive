import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {SearchInputComponent} from './search-input/search-input.component';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {OutputSearchDataComponent} from './output-search-data/output-search-data.component';
import {RouterModule} from '@angular/router';
import {DescriptionComponent} from './description/description.component';
import {routes} from './route';
import { ChartsModule } from 'ng2-charts';
import {SharedService} from './service/shared/shared.service';
import {StatisticsComponent} from './statistics/statistics.component';

@NgModule({
  declarations: [
    AppComponent,
    SearchInputComponent,
    OutputSearchDataComponent,
    DescriptionComponent,
    StatisticsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    ChartsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [SharedService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
