import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {SubmitOrderComponent} from './components/submit-order/submit-order.component'
import {OrderListCpcComponent} from './components/order-list-cpc/order-list-cpc.component'
import {CheckOrderStatusComponent} from './components/check-order-status/check-order-status.component'


const routes: Routes = [
  {path: '', redirectTo: 'submitorder', pathMatch: 'full'},
  {path: 'submitorder', component: SubmitOrderComponent},
  {path: 'orderlistcpc', component: OrderListCpcComponent},
  {path: 'checkorderstatus', component: CheckOrderStatusComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
