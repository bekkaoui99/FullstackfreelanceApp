import {Component, OnInit} from '@angular/core';
import {CompanyService} from "../../../../services/company.service";
import {OfferResponse} from "../../../../types/Offer-response";

@Component({
  selector: 'app-company-offers',
  templateUrl: './company-offers.component.html',
  styleUrls: ['./company-offers.component.css']
})
export class CompanyOffersComponent implements OnInit{
  offers:OfferResponse[] = [];
  constructor(private companyService:CompanyService) {
  }
  ngOnInit(): void {
    this.companyService.getAllOffers().subscribe({
      next:(data)=>{
        this.offers = data;
      }
    })
  }

}
