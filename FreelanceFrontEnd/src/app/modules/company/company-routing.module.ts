import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CompanyComponent } from './company.component';
import {CompanyOffersComponent} from "./page/company-offers/company-offers.component";
import {CreateOfferComponent} from "./component/create-offer/create-offer.component";

const routes: Routes = [
  {
    path: '',
    component: CompanyComponent,
    children:[
      {
        path:'',
        redirectTo:'offers',
        pathMatch:"full"
      },
      {
        path:'offers',
        component:CompanyOffersComponent
      },
      {
        path:'create-offer',
        component:CreateOfferComponent
      }
    ]
  }
  ];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CompanyRoutingModule { }
