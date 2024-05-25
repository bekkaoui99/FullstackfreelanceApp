import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from "./services/authentication.service";
import {Router} from "@angular/router";
import {TokenService} from "./services/token.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  private authenticated: boolean = false;
  private role: string = "";

  constructor(
    private router:Router,
    private token:TokenService,
    private authService:AuthenticationService

  ) {
  }

  ngOnInit(): void {
    this.authService.isAuthenticated()
  }

}
