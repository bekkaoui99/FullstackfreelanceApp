import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompanyOfferComponent } from './company-offer.component';

describe('CompanyOfferComponent', () => {
  let component: CompanyOfferComponent;
  let fixture: ComponentFixture<CompanyOfferComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CompanyOfferComponent]
    });
    fixture = TestBed.createComponent(CompanyOfferComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
