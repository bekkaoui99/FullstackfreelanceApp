import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CompanyRoutingModule } from './company-routing.module';
import { CompanyComponent } from './company.component';
import { CompanyOffersComponent } from './page/company-offers/company-offers.component';
import { CompanyOfferComponent } from './component/company-offer/company-offer.component';
import { CompanyDashboardComponent } from './component/company-dashboard/company-dashboard.component';
import {AppModule} from "../../app.module";
import { CreateOfferComponent } from './component/create-offer/create-offer.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";




@NgModule({
  declarations: [
    CompanyComponent,
    CompanyOffersComponent,
    CompanyOfferComponent,
    CompanyDashboardComponent,
    CreateOfferComponent
  ],
  imports: [
    CommonModule,
    CompanyRoutingModule,
    FormsModule,
    ReactiveFormsModule,
  ]
})
export class CompanyModule { }
