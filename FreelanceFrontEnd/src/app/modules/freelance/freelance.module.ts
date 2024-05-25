import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FreelanceRoutingModule } from './freelance-routing.module';
import { FreelanceComponent } from './freelance.component';
import { FreelanceDashboardComponent } from './component/freelance-dashboard/freelance-dashboard.component';
import { FreelanceOffersComponent } from './page/freelance-offers/freelance-offers.component';
import { FreelanceOfferComponent } from './component/freelance-offer/freelance-offer.component';
import { ProfileComponent } from './page/profile/profile.component';


@NgModule({
    declarations: [
        FreelanceComponent,
        FreelanceDashboardComponent,
        FreelanceOffersComponent,
        FreelanceOfferComponent,
        ProfileComponent
    ],
    exports: [
        FreelanceComponent
    ],
    imports: [
        CommonModule,
        FreelanceRoutingModule
    ]
})
export class FreelanceModule { }
