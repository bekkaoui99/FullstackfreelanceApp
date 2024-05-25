import {Component, Input} from '@angular/core';
import {OfferResponse} from "../../../../types/Offer-response";

@Component({
  selector: 'app-company-offer',
  templateUrl: './company-offer.component.html',
  styleUrls: ['./company-offer.component.css']
})
export class CompanyOfferComponent {
  @Input() offer: OfferResponse | undefined;
}
