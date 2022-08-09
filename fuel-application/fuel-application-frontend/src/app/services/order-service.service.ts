import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Order } from '../models/order.model';
import { TagContentType } from '@angular/compiler';

const baseUrlSaveOrder = 'http://localhost:8081/api/saveorder'
const baseUrlGetAllOrders = 'http://localhost:8081/api/getallorders'
const baseUrlGetOrder = 'http://localhost:8081/api/getorder'
const baseUrlUpdateOrderRecieved = 'http://localhost:8081/api/orderreceived'

@Injectable({
  providedIn: 'root'
})
export class OrderServiceService {
  constructor(private http: HttpClient) { }
  getAll(): Observable<Order[]> {
    return this.http.get<Order[]>(baseUrlGetAllOrders);
  }
  get(orderRefId: any): Observable<Order> {
    return this.http.get<Order>(`${baseUrlGetOrder}/${orderRefId}`);
  }
  create(data: any): Observable<any> {
    return this.http.post(baseUrlSaveOrder, data);
  }
  updateStatusReceived(orderRefId: any): Observable<any> {
    return this.http.put(`${baseUrlUpdateOrderRecieved}/${orderRefId}`, null);
  }
}
