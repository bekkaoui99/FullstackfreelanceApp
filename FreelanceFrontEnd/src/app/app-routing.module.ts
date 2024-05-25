import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./pages/home/home.component";
import {FreelancesComponent} from "./pages/freelances/freelances.component";
import {OffersComponent} from "./pages/offers/offers.component";
import {ContactComponent} from "./pages/contact/contact.component";
import {authenticationGuard} from "./services/guard/authentication.guard";

const routes: Routes = [

  {
    path: '',
    redirectTo:"/home",
    pathMatch:"full"
  },
  {
    path: 'home',
    component:HomeComponent
  },
  {
    path: 'freelances',
    component:FreelancesComponent
  },
  {
    path: 'offer',
    component:OffersComponent
  },
  {
    path: 'contact',
    component:ContactComponent
  },
  {
    path: 'company',
    canActivate:[authenticationGuard],
    loadChildren: () => import('./modules/company/company.module').then(m => m.CompanyModule
    )
  },
  {
    path: 'auth',
    loadChildren: () => import('./modules/authentication/authentication.module').then(m => m.AuthenticationModule)
  },

  { path: 'freelance',
    canActivate:[authenticationGuard],
    loadChildren: () => import('./modules/freelance/freelance.module').then(m => m.FreelanceModule) }
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
