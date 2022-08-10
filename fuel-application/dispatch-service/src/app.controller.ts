import { Body, Controller, Get, Param, Put } from '@nestjs/common';
import { AppService } from './app.service';
import { DispatchOrderDto } from './dto/dispatch-order.dto';

@Controller('/api')
export class AppController {
  constructor(private readonly appService: AppService) {}

  @Get()
  getHello(): string {
    return this.appService.getHello();
  }

  @Put('/dispatchOrder')
  dispatchOrder(@Body() dispatchOrderDto : DispatchOrderDto){
    this.appService.dispatchOrder(dispatchOrderDto);
  }
}
