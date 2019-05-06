import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpCompleteComponent } from './emp-complete.component';

describe('EmpCompleteComponent', () => {
  let component: EmpCompleteComponent;
  let fixture: ComponentFixture<EmpCompleteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmpCompleteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmpCompleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
