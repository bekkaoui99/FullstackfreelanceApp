import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {BehaviorSubject, Observable, tap} from "rxjs";
import {FreelanceResponse} from "../types/Freelance-response";
import {LoginResponse} from "../types/Login-response";
import {LoginRequest} from "../types/Login-request";
import {CompanyRegistrationRequest} from "../types/CompanyRegistration-request";
import {FreelanceRegistrationRequest} from "../types/FreelanceRegistration-request";
import {TokenService} from "./token.service";
import {jwtDecode} from "jwt-decode";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  public authenticatedSubject: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
  public roleSubject: BehaviorSubject<string> = new BehaviorSubject<string>("");



  role: string | undefined | null = this.roleSubject.value;
  userName: string | undefined | null ;
  authenticated: boolean = this.authenticatedSubject.value;


  constructor(
    private http:HttpClient,
    private router:Router,
    private tokenService:TokenService

  ) {
  }
  isTokenExpired(token: string): boolean {
      const { exp } = jwtDecode<{ exp: number }>(token);
      if (!exp) {
        return false;
      }
      const currentTime = Math.floor(new Date().getTime() / 1000);
      return exp < currentTime;
    }



    public showUserName():string{
     return this.getUsername(this.tokenService.getToken() as string) as string;
    }

  public isAuthenticated()  {
    const token = this.tokenService.getToken();
      if(token !== null && !this.isTokenExpired(token)){
        this.authenticatedSubject.next(true);
        this.roleSubject.next(this.getUserRole(token) as string);
      }
  }

  public loadingData(loginResponse:LoginResponse){
    this.tokenService.saveToken(loginResponse.accessToken , loginResponse.refreshToken)
    this.authenticatedSubject.next(true);
    this.userName = this.getUsername(loginResponse.accessToken)
    this.role =  this.getUserRole(loginResponse.accessToken);
    this.roleSubject.next(this.role as string)
  }

  public logout(){
    this.authenticatedSubject.next(false);
    this.tokenService.clearTokens();
    this.roleSubject.next("")
  }



  getUsername(accessToken:string): string | undefined | null {
    const token = accessToken;
    if (!token) {
      return null;
    }
    const decoded = jwtDecode(token);
    return decoded ? decoded.sub : null;
  }

  getUserRole(accessToken:string): string | undefined | null {
    const token = accessToken;
    if (!token) {
      return null;
    }
    const decoded = jwtDecode(token);
    return decoded ? decoded.role : null;
  }

  public login(loginRequest:LoginRequest):Observable<LoginResponse>{
    return this.http.post<LoginResponse>("auth/login" , loginRequest);

  }

  public companyRegistration(companyRegistrationRequest:CompanyRegistrationRequest):Observable<CompanyRegistrationRequest>{
    return this.http.post<CompanyRegistrationRequest>("auth/companyRegistration" , companyRegistrationRequest);
  }

  public freelanceRegistration(freelanceRegistrationRequest:FreelanceRegistrationRequest):Observable<FreelanceRegistrationRequest>{
    return this.http.post<FreelanceRegistrationRequest>("auth/freelanceRegistration" , freelanceRegistrationRequest);
  }

}

