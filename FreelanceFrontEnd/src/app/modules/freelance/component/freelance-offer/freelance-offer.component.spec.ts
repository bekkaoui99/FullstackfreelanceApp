import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FreelanceOfferComponent } from './freelance-offer.component';

describe('FreelanceOfferComponent', () => {
  let component: FreelanceOfferComponent;
  let fixture: ComponentFixture<FreelanceOfferComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FreelanceOfferComponent]
    });
    fixture = TestBed.createComponent(FreelanceOfferComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
