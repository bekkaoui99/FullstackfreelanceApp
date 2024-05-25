import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import { HomeComponent } from './pages/home/home.component';
import { FreelancesComponent } from './pages/freelances/freelances.component';
import { FreelanceComponent } from './components/freelance/freelance.component';
import { OfferComponent } from './components/offer/offer.component';
import { OffersComponent } from './pages/offers/offers.component';
import { ContactComponent } from './pages/contact/contact.component';
import {JwtAuthInterceptor} from "./services/interceptor/jwt-auth.interceptor";

@NgModule({
    declarations: [
        AppComponent,
        HeaderComponent,
        FooterComponent,
        HomeComponent,
        FreelancesComponent,
        FreelanceComponent,
        OfferComponent,
        OffersComponent,
        ContactComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        ReactiveFormsModule,
        HttpClientModule,

    ],
    providers: [
        {
            provide: HTTP_INTERCEPTORS,
            useClass: JwtAuthInterceptor,
            multi: true
        }
    ],
    bootstrap: [AppComponent]
})
export class AppModule { }
