package com.enclave.backend.service;

import com.enclave.backend.dto.OrderDTO;
import com.enclave.backend.entity.Order;

import java.util.List;

public interface OrderService {

    Order createNewOrder(OrderDTO dto);

    Order updateOrder(Order order);

    Order findOrderById(String id);

    Order findOrderByOrdinalNumber(); // seller tim order

    double calculateTotal();

    boolean cancelOrder(Order order);

    boolean validateOrder();

    List<Order> getOrders();
}
