import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterFreelanceComponent } from './register-freelance.component';

describe('RegisterFreelanceComponent', () => {
  let component: RegisterFreelanceComponent;
  let fixture: ComponentFixture<RegisterFreelanceComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RegisterFreelanceComponent]
    });
    fixture = TestBed.createComponent(RegisterFreelanceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
