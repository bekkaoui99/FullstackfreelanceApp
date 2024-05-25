import {Component, Input} from '@angular/core';
import {OfferResponse} from "../../../../types/Offer-response";

@Component({
  selector: 'app-freelance-offer',
  templateUrl: './freelance-offer.component.html',
  styleUrls: ['./freelance-offer.component.css']
})
export class FreelanceOfferComponent {
  @Input() offer: OfferResponse | undefined;
}
