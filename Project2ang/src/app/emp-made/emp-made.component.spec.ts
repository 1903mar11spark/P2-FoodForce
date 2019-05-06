import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpMadeComponent } from './emp-made.component';

describe('EmpMadeComponent', () => {
  let component: EmpMadeComponent;
  let fixture: ComponentFixture<EmpMadeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmpMadeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmpMadeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
