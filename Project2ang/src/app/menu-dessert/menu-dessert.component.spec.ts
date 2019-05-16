import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuDessertComponent } from './menu-dessert.component';

describe('MenuDessertComponent', () => {
  let component: MenuDessertComponent;
  let fixture: ComponentFixture<MenuDessertComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MenuDessertComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuDessertComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
