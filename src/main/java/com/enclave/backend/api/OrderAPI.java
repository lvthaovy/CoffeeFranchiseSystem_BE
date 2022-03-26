package com.enclave.backend.api;

import com.enclave.backend.dto.OrderDTO;
import com.enclave.backend.entity.Order;
import com.enclave.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderAPI {

    @Autowired
    private OrderService orderService;

    @PostMapping("/")
    public Order createNewOrder(@RequestBody OrderDTO dto) {
        return orderService.createNewOrder(dto);
    }

    @GetMapping("/all")
    public List<Order> getOrders() {
        return orderService.getOrders();
    }
}
