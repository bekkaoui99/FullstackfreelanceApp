import { CanActivateFn } from '@angular/router';
import {inject, Inject} from "@angular/core";
import {AuthenticationService} from "../authentication.service";

export const authenticationGuard: CanActivateFn = (route, state) => {

  const authenticationService = inject(AuthenticationService);


  var test = false;
  authenticationService.authenticatedSubject.subscribe({
    next:(data)=>{
      test = data;
    }
  })
  console.log("guard " +  test)
  return test;

};
