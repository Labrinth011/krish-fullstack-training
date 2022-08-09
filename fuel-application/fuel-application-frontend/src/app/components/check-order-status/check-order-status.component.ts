import { state } from '@angular/animations';
import { Component, OnInit } from '@angular/core';
import { SafeHtml } from '@angular/platform-browser';
import { Order } from 'src/app/models/order.model';
import { OrderServiceService } from 'src/app/services/order-service.service';

@Component({
  selector: 'app-check-order-status',
  templateUrl: './check-order-status.component.html',
  styleUrls: ['./check-order-status.component.css']
})
export class CheckOrderStatusComponent implements OnInit {
  orderDetailsReceived = false;
  orderRefID = '';
  order: Order = {};
  constructor(private orderService: OrderServiceService) { }
  ngOnInit(): void {
  }
  getOrderByRefID(): void {
    this.orderService.get(this.orderRefID)
      .subscribe({
        next: (data) => {
          this.orderDetailsReceived = true;
          this.order = data;
          // console.log(data);
        },
        error: (e) => console.error(e)
      });
  }
  confirmOrderReceived(): void{
    this.orderService.updateStatusReceived(this.orderRefID)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.getOrderByRefID();
        },
        error: (e) => console.error(e)
      });
  }
}
