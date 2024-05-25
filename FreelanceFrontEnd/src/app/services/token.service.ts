import { Injectable } from '@angular/core';
import {BehaviorSubject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TokenService {
  private tokenSubject: BehaviorSubject<string | null> = new BehaviorSubject<string | null>(null);


  constructor() { }

  public setToken(token:string){
    localStorage.setItem("accessToken" , token);
  }


  getToken(): string | null {
    return localStorage.getItem("accessToken") as string;
  }

  public setRefreshToken(refreshToken:string){
    localStorage.setItem("refreshToken" , refreshToken);
  }

  public getRefreshToken():string{
    return localStorage.getItem("refreshToken") as string;
  }

  public saveToken(token:string ,refreshToken:string){
    this.setToken(token);
    this.setRefreshToken(refreshToken);
    this.tokenSubject.next(token);
  }

  clearTokens(): void {
    localStorage.removeItem('accessToken');
    localStorage.removeItem('refreshToken');
    this.tokenSubject.next(null);
  }

}
