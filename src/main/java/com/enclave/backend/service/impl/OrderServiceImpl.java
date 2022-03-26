package com.enclave.backend.service.impl;

import com.enclave.backend.converter.OrderConverter;
import com.enclave.backend.dto.OrderDTO;
import com.enclave.backend.entity.Branch;
import com.enclave.backend.entity.Order;
import com.enclave.backend.repository.OrderRepository;
import com.enclave.backend.service.BranchService;
import com.enclave.backend.service.EmployeeService;
import com.enclave.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private BranchService branchService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private OrderConverter orderConverter;

    @Autowired
    private OrderRepository orderRepository;

//    private final RedisTemplate<String, Order> redisTemplate;
//
//    private final HashOperations hashOperations;
//
//    public OrderServiceImpl(RedisTemplate<String, Order> redisTemplate) {
//        this.redisTemplate = redisTemplate;
//        hashOperations = redisTemplate.opsForHash();
//    }


    @Override
    public Order createNewOrder(OrderDTO dto) {
        short employeeId = dto.getCreatedByEmpId();

        short branchId = employeeService.getEmployeeById(employeeId).getBranch().getId();
        Branch branch = branchService.getBranchById(branchId);


//        Date date = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
//        String strDate = formatter.format(date);
//
//        String key = String.valueOf(branchId) + strDate;
//        System.out.println(key);


        Order newOrder = orderConverter.toEntity(dto);

//        return  orderRepository.save(newOrder);
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Order updateOrder(Order order) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Order findOrderById(String id) {
        return orderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid order Id: " + id));
    }

    @Override
    public Order findOrderByOrdinalNumber() {
        return null;
    }

    @Override
    public double calculateTotal() {
        return 0;
    }

    @Override
    public boolean cancelOrder(Order order) {
        Order oldOrder = findOrderById(order.getId());
        oldOrder.setStatus("");
//        return orderRepository.save(oldOrder);
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean validateOrder() {
        return false;
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }
}
