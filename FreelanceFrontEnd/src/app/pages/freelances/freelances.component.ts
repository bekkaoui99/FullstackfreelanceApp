import {Component, OnInit} from '@angular/core';
import {FreelanceRegistrationRequest} from "../../types/FreelanceRegistration-request";
import {FreelanceResponse} from "../../types/Freelance-response";
import {FreelanceService} from "../../services/freelance.service";

@Component({
  selector: 'app-freelances',
  templateUrl: './freelances.component.html',
  styleUrls: ['./freelances.component.css']
})
export class FreelancesComponent implements OnInit{

  freelances:FreelanceResponse[] = [];

  constructor(private freelanceService:FreelanceService) {
  }

  public getAllFreelances():void{
     this.freelanceService.getAllFreelances().subscribe({
       next:(data)=>{
         this.freelances = data;
       }
     })
  }

  ngOnInit(): void {
    this.getAllFreelances();
  }


}
