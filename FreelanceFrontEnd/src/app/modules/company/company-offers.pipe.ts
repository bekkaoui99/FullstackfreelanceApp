import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'companyOffers'
})
export class CompanyOffersPipe implements PipeTransform {

  transform(value: unknown, ...args: unknown[]): unknown {
    return null;
  }

}
