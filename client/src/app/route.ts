import {Routes} from "@angular/router";
import {SearchInputComponent} from "./search-input/search-input.component";
import {DescriptionComponent} from "./description/description.component";
import {StatisticsComponent} from "./statistics/statistics.component";

export const routes: Routes = [
  {path: 'search', component: SearchInputComponent},
  {path: 'description', component: DescriptionComponent},
  {path: 'statistics', component: StatisticsComponent},
  {path: '', redirectTo: 'search', pathMatch: 'full'}
];
