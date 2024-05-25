import { Component } from '@angular/core';
import {OfferRequest} from "../../../../types/Offer-request";
import {ExperienceLevel} from "../../../../types/ExperienceLevel";
import {Router} from "@angular/router";

@Component({
  selector: 'app-create-offer',
  templateUrl: './create-offer.component.html',
  styleUrls: ['./create-offer.component.css']
})
export class CreateOfferComponent {
  created: boolean = false;
  createOfferForm:OfferRequest= {
    title:"",
    description:"",
    experienceLevel:ExperienceLevel.INTERNSHIP,
    publishDate:new Date(),
    offerTechnologies:[],
    companyName:""
  }
  experienceLevels = Object.values(ExperienceLevel);
  constructor(private router:Router) {
  }
  createOffer() {

  }

  clearForm() {

  }

}
