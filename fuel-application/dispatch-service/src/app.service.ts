import { Inject, Injectable } from '@nestjs/common';
import { ClientKafka } from '@nestjs/microservices';
import { DispatchOrderDto } from './dto/dispatch-order.dto';
import { OrderDispatchedEvent } from './order-dispatched.event';

@Injectable()
export class AppService {
  constructor(
    @Inject('ORDER_SERVICE') private readonly orderClient: ClientKafka,
  ){}

  getHello(): string {
    return 'Hello World!';
  }
  dispatchOrder(dispatchOrderDto : DispatchOrderDto){
    this.orderClient.emit('dispatched-order', new OrderDispatchedEvent(
      dispatchOrderDto.orderRefId,
      dispatchOrderDto.requiredCapacity,
      dispatchOrderDto.fuelType));
  }
}

