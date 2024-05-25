import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FreelanceComponent } from './freelance.component';
import {FreelanceOffersComponent} from "./page/freelance-offers/freelance-offers.component";
import {ProfileComponent} from "./page/profile/profile.component";

const routes: Routes = [
  {
    path: '',
    component: FreelanceComponent,
    children:[
      {
        path:'offers',
        component:FreelanceOffersComponent
      },
      {
        path:'profile',
        component:ProfileComponent
      },
    ]
  }
  ];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FreelanceRoutingModule { }
