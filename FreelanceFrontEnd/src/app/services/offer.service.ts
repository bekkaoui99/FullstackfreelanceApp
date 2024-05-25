import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {FreelanceResponse} from "../types/Freelance-response";
import {OfferResponse} from "../types/Offer-response";

@Injectable({
  providedIn: 'root'
})
export class OfferService {

  constructor(private http:HttpClient) { }

  public getAllOffers():Observable<OfferResponse[]>{
    return this.http.get<OfferResponse[]>("api/v1/guests/offer/list");
  }
}
