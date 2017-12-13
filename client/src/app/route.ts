import {Routes} from "@angular/router";
import {SearchInputComponent} from "./search-input/search-input.component";
import {DescriptionComponent} from "./description/description.component";

export const routes: Routes = [
  {path: 'search', component: SearchInputComponent},
  {path: 'description', component: DescriptionComponent},
  {path: '', redirectTo: 'search', pathMatch: 'full'}
];
