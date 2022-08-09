import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SubmitOrderComponent } from './components/submit-order/submit-order.component';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { OrderListCpcComponent } from './components/order-list-cpc/order-list-cpc.component';
import { CheckOrderStatusComponent } from './components/check-order-status/check-order-status.component';

@NgModule({
  declarations: [
    AppComponent,
    SubmitOrderComponent,
    OrderListCpcComponent,
    CheckOrderStatusComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
