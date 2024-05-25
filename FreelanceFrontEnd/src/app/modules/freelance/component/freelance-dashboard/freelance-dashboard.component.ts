import { Component } from '@angular/core';
import {AuthenticationService} from "../../../../services/authentication.service";

@Component({
  selector: 'app-freelance-dashboard',
  templateUrl: './freelance-dashboard.component.html',
  styleUrls: ['./freelance-dashboard.component.css']
})
export class FreelanceDashboardComponent {
  userName = "";
  constructor(private authService:AuthenticationService) {
  }

  ngOnInit(): void {
    this.userName = this.authService.showUserName();
  }
}
