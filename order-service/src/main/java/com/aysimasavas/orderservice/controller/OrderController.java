package com.aysimasavas.orderservice.controller;

import com.aysimasavas.orderservice.dto.OrderRequest;
import com.aysimasavas.orderservice.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest){
        orderService.pleceOrder(orderRequest);
        return "order place succesfully";
    }
}
