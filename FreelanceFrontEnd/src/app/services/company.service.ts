import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {FreelanceResponse} from "../types/Freelance-response";
import {OfferResponse} from "../types/Offer-response";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class CompanyService {
  private URL = environment.apiUrl;
  constructor(private http:HttpClient) { }

  public getAllOffers():Observable<OfferResponse[]>{
    return this.http.get<OfferResponse[]>(`${this.URL}/api/v1/companies/offer/list`);
  }
}
