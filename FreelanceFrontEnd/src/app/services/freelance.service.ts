import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {FreelanceRegistrationRequest} from "../types/FreelanceRegistration-request";
import {FreelanceResponse} from "../types/Freelance-response";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class FreelanceService {
  private URL = environment.apiUrl;
  constructor(private http:HttpClient) { }

  public getAllFreelances():Observable<FreelanceResponse[]>{
    return this.http.get<FreelanceResponse[]>(`${this.URL}/api/v1/guests/freelance/list`);
  }
}
