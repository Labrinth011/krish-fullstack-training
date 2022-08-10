import { Component, OnInit } from '@angular/core';
import { Order } from 'src/app/models/order.model';
import { OrderServiceService } from 'src/app/services/order-service.service';

@Component({
  selector: 'app-order-list-cpc',
  templateUrl: './order-list-cpc.component.html',
  styleUrls: ['./order-list-cpc.component.css']
})
export class OrderListCpcComponent implements OnInit {
  orderList?: Order[];
  currentOrder: Order = {};
  currentIndex = -1;
  constructor(private orderService: OrderServiceService) { }
  ngOnInit(): void {
    this.retrieveOrders();
  }
  retrieveOrders(): void {
    this.orderService.getAll()
      .subscribe({
        next: (data) => {
          this.orderList = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }
  dispatchOrder(order : Order){
    console.log(order.orderRefId);
    this.orderService.dispatchOrder(order)
    .subscribe({
      next: (res) => {
        console.log(res);
        window.location.reload();
      },
      error: (e) => console.error(e)
    });
  }
}
