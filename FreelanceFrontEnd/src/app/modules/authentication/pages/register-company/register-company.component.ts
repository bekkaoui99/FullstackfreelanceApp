import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {ExceptionResponse} from "../../../../types/Exception-response";
import {FreelanceRegistrationRequest} from "../../../../types/FreelanceRegistration-request";
import {CompanyRegistrationRequest} from "../../../../types/CompanyRegistration-request";
import {AuthenticationService} from "../../../../services/authentication.service";


@Component({
  selector: 'app-register-company',
  templateUrl: './register-company.component.html',
  styleUrls: ['./register-company.component.css']
})
export class RegisterCompanyComponent {


  constructor(
    private router:Router,
    private authService:AuthenticationService

  ) {
  }


  registered: boolean = false;

  exception: ExceptionResponse = {
    message :"",
    status:"",
    code:0
  };

  formRegister:CompanyRegistrationRequest = {
    companyName :"",
    email:"",
    address:"",
    password : "",
    confirmationPassword : ""
  }

  register() {

    this.authService.companyRegistration(this.formRegister).subscribe({
      next:(data)=>{
        this.registered =true;
      }
    })
  }

  clearForm() {
    this.formRegister = {
      companyName :"",
      email:"",
      address:"",
      password : "",
      confirmationPassword : ""
    }
  }

  navigateToLogin() {
    this.router.navigateByUrl("auth/login")
  }

}
