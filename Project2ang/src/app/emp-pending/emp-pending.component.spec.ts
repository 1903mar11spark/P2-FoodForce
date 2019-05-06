import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpPendingComponent } from './emp-pending.component';

describe('EmpPendingComponent', () => {
  let component: EmpPendingComponent;
  let fixture: ComponentFixture<EmpPendingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmpPendingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmpPendingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
