import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BackOfficeRoutingModule } from './back-office-routing.module';
import { BackOfficeComponent } from './back-office.component';
import { ClubComponent } from './club/club.component';


@NgModule({
  declarations: [
    BackOfficeComponent,
    ClubComponent
  ],
  imports: [
    CommonModule,
    BackOfficeRoutingModule
  ],
  exports:[
    ClubComponent
  ]
})
export class BackOfficeModule { }
