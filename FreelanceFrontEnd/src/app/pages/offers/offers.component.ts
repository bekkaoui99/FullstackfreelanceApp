import {Component, OnInit} from '@angular/core';
import {OfferResponse} from "../../types/Offer-response";
import {OfferService} from "../../services/offer.service";

@Component({
  selector: 'app-offers',
  templateUrl: './offers.component.html',
  styleUrls: ['./offers.component.css']
})
export class OffersComponent implements OnInit{

  offers:OfferResponse[] = [];

  constructor(private offerService:OfferService) {
  }

  public getAllOffers():void{
     this.offerService.getAllOffers().subscribe({
      next:(data)=> {
        this.offers = data;
      }
    })
  }

  ngOnInit(): void {
    this.getAllOffers()
  }
}
