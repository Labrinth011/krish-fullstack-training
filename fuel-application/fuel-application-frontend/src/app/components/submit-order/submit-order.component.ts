import { Component, OnInit } from '@angular/core';
import {Order} from 'src/app/models/order.model'
import { OrderServiceService } from 'src/app/services/order-service.service';

@Component({
  selector: 'app-submit-order',
  templateUrl: './submit-order.component.html',
  styleUrls: ['./submit-order.component.css']
})
export class SubmitOrderComponent implements OnInit {
  response: Order = {};
  order: Order = {
    stationID: 0,
    stationName: '',
    location: '',
    requiredCapacity: 0,
    fuelType: ''
  };
  submitted = false;
  constructor(private orderService: OrderServiceService) { }
  ngOnInit(): void {
  }
  submitOrder(): void{
    const data = {
      stationID: this.order.stationID,
      stationName: this.order.stationName,
      location: this.order.location,
      requiredCapacity: this.order.requiredCapacity,
      fuelType: this.order.fuelType
    };
    this.orderService.create(data)
    .subscribe({
      next: (res) => {
        console.log(res);
        this.response.orderRefId = res.orderRefId;        
        this.submitted = true;
      },
      error: (e) => console.error(e)
    });
  }
  newOrder(): void {
    this.submitted = false;
    this.order = {
      stationID: 0,
      stationName: '',
      location: '',
      requiredCapacity: 0,
      fuelType: ''
    };
  }
}
