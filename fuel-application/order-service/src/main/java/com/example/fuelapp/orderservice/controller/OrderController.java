package com.example.fuelapp.orderservice.controller;

import com.example.fuelapp.orderservice.model.Order;
import com.example.fuelapp.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/saveorder")
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @GetMapping("/getorder/{orderRefId}")
    public ResponseEntity<Optional<Order>> getOrder(@PathVariable int orderRefId){
        return orderService.getOrder(orderRefId);
    }

    @PutMapping("/orderreceived/{orderRefId}")
    public ResponseEntity<Order> orderReceived(@PathVariable int orderRefId ) {
        return orderService.orderReceived(orderRefId);
    }

    @GetMapping("/getallorders")
    public ResponseEntity<List<Order>> getAllOrders(){
        return orderService.getAllOrders();
    }
}
