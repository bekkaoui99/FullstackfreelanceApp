import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from "../../../../services/authentication.service";

@Component({
  selector: 'app-company-dashboard',
  templateUrl: './company-dashboard.component.html',
  styleUrls: ['./company-dashboard.component.css']
})
export class CompanyDashboardComponent implements OnInit{

  userName = "";
    constructor(private authService:AuthenticationService) {
    }

  ngOnInit(): void {
      this.userName = this.authService.showUserName();
  }
}
