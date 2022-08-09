import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderListCpcComponent } from './order-list-cpc.component';

describe('OrderListCpcComponent', () => {
  let component: OrderListCpcComponent;
  let fixture: ComponentFixture<OrderListCpcComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrderListCpcComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OrderListCpcComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
