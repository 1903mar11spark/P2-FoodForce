import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuWingsComponent } from './menu-wings.component';

describe('MenuWingsComponent', () => {
  let component: MenuWingsComponent;
  let fixture: ComponentFixture<MenuWingsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MenuWingsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuWingsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
