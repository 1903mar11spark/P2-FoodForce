import { TestBed } from '@angular/core/testing';

import { FoodsService } from './foods.service';

describe('FoodsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FoodsService = TestBed.get(FoodsService);
    expect(service).toBeTruthy();
  });
});
