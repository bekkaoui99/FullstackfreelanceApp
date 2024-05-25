import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from "../../services/authentication.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit{

  authenticated=false;
  role="";
  constructor(
    private authService:AuthenticationService,
    private router:Router
  ) {
  }

  ngOnInit(): void {
    this.authService.authenticatedSubject.subscribe(value => {
      this.authenticated = value;
    });
    this.authService.roleSubject.subscribe(value => {
      this.role = value;
    });
  }

  logout() {
    this.authService.logout();
    this.router.navigateByUrl("/home")
  }
}
