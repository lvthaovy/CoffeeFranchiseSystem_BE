package com.enclave.backend.service;

import com.enclave.backend.entity.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class OrderIdGeneratorService {

    @Autowired
    private static RedisService redisService;

    public String createOrderId(Branch branch, Date currentDate) {
        String branchId = String.valueOf(branch.getId());

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
        String strDate = formatter.format(date);

        String key = branchId + strDate;

        String orderId = String.valueOf(redisService.increment(key));

        return orderId;
    }
}
