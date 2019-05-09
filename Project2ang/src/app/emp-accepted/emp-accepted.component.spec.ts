import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpAcceptedComponent } from './emp-accepted.component';

describe('EmpAcceptedComponent', () => {
  let component: EmpAcceptedComponent;
  let fixture: ComponentFixture<EmpAcceptedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmpAcceptedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmpAcceptedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
