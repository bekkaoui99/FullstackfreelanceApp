import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import {AuthenticationService} from "../authentication.service";
import {TokenService} from "../token.service";

@Injectable()
export class JwtAuthInterceptor implements HttpInterceptor {

  constructor(private tokenService:TokenService) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    const token = this.tokenService.getToken();

    // Clone the request and add the Authorization header if the token is available
    let authReq = request;
    if(
      !request.url.includes("/auth/login") ||
      !request.url.includes("/auth/companyRegistration") ||
      !request.url.includes("/auth/freelanceRegistration")
    ){
      if (token) {
        authReq = request.clone({
          setHeaders: {
            Authorization: `Bearer ${token}`
          }
        });
      }
    }
    return next.handle(authReq);
  }
}
