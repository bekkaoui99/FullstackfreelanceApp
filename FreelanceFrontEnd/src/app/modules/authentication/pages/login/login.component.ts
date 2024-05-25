import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {LoginRequest} from "../../../../types/Login-request";
import {ExceptionResponse} from "../../../../types/Exception-response";
import {AuthenticationService} from "../../../../services/authentication.service";
import {BehaviorSubject} from "rxjs";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  constructor(
    private router:Router,
    private authService:AuthenticationService
  ) {
  }

  authentication:LoginRequest = {
    email :"",
    password : ""

  }
  exception: ExceptionResponse = {
    message :"",
    status:"",
    code:0
  };

  loggedIn: boolean = false;

  clearForm() {
    this.authentication.email= "";
    this.authentication.password= "";
  }

  navigateToRegister() {
    this.router.navigateByUrl("auth/register");
  }

  login() {
    this.authService.login(this.authentication).subscribe({
      next:(data)=>{
        this.authService.loadingData(data);
        if(this.authService.role == "FREELANCE"){
          this.router.navigateByUrl("/freelance")
        } if(this.authService.role == "COMPANY"){
          this.router.navigateByUrl("/company")
        }
      }
    })
  }

  ngOnInit(): void {

  }
}
