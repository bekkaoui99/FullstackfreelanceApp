import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FreelanceOffersComponent } from './freelance-offers.component';

describe('FreelanceOffersComponent', () => {
  let component: FreelanceOffersComponent;
  let fixture: ComponentFixture<FreelanceOffersComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FreelanceOffersComponent]
    });
    fixture = TestBed.createComponent(FreelanceOffersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
