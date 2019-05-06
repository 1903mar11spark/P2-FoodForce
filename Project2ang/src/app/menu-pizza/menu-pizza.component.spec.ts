import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuPizzaComponent } from './menu-pizza.component';

describe('MenuPizzaComponent', () => {
  let component: MenuPizzaComponent;
  let fixture: ComponentFixture<MenuPizzaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MenuPizzaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuPizzaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
