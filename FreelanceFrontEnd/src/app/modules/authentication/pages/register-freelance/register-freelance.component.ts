import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {ExceptionResponse} from "../../../../types/Exception-response";
import {FreelanceRegistrationRequest} from "../../../../types/FreelanceRegistration-request";
import {AuthenticationService} from "../../../../services/authentication.service";

@Component({
  selector: 'app-register-freelance',
  templateUrl: './register-freelance.component.html',
  styleUrls: ['./register-freelance.component.css']
})
export class RegisterFreelanceComponent {


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

  formRegister:FreelanceRegistrationRequest = {
    firstName :"",
    lastName :"",
    userName :"",
    email:"",
    city:"",
    jobTitle:"",
    phoneNumber:"",
    password : "",
    confirmationPassword : ""
  }

  register() {

    this.authService.freelanceRegistration(this.formRegister).subscribe({
      next:(data)=>{
        this.registered = true;
      }
    })
  }

  clearForm() {
    this.formRegister = {
      firstName :"",
      lastName :"",
      userName :"",
      email:"",
      city:"",
      jobTitle:"",
      phoneNumber:"",
      password : "",
      confirmationPassword : ""
    }
  }

  navigateToLogin() {
    this.router.navigateByUrl("auth/login")
  }

}
