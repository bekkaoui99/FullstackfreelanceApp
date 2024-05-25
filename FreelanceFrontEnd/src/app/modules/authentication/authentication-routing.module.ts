import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthenticationComponent } from './authentication.component';
import {LoginComponent} from "./pages/login/login.component";
import {RegisterComponent} from "./pages/register/register.component";
import {RegisterFreelanceComponent} from "./pages/register-freelance/register-freelance.component";
import {RegisterCompanyComponent} from "./pages/register-company/register-company.component";

const routes: Routes = [
  {
    path: '',
    component: AuthenticationComponent,
    children:[
      {
        path:"login",
        component:LoginComponent
      },
      {
        path:"register",
        component:RegisterComponent
      },
      {
        path:"company-registration",
        component:RegisterCompanyComponent
      },
      {
        path:"freelance-registration",
        component:RegisterFreelanceComponent
      }

    ]
  }
  ];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AuthenticationRoutingModule { }
