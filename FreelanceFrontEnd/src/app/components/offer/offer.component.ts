import {Component, Input} from '@angular/core';
import {OfferResponse} from "../../types/Offer-response";
import {of} from "rxjs";

@Component({
  selector: 'app-offer',
  templateUrl: './offer.component.html',
  styleUrls: ['./offer.component.css']
})
export class OfferComponent {
  @Input() offer: OfferResponse | undefined;

}
