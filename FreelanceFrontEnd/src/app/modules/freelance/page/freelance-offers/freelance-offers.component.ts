import {Component, OnInit} from '@angular/core';
import {OfferResponse} from "../../../../types/Offer-response";
import {CompanyService} from "../../../../services/company.service";
import {OfferService} from "../../../../services/offer.service";

@Component({
  selector: 'app-freelance-offers',
  templateUrl: './freelance-offers.component.html',
  styleUrls: ['./freelance-offers.component.css']
})
export class FreelanceOffersComponent implements OnInit{
  offers:OfferResponse[] = [];
  constructor(private offerService:OfferService) {
  }
  ngOnInit(): void {
    this.offerService.getAllOffers().subscribe({
      next:(data)=>{
        this.offers = data;
      }
    })
  }
}
