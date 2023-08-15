import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FrontOfficeComponent} from "./front-office/front-office.component";
import {BackOfficeComponent} from "./back-office/back-office.component";

const routes: Routes = [
  {path: 'front-office', component: FrontOfficeComponent},
  {path: 'back-office', component: BackOfficeComponent},
  {path: '', redirectTo: '/front-office', pathMatch: 'full'}, // Default route
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
