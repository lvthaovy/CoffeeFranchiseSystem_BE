package com.enclave.backend.api;

import com.enclave.backend.dto.EmployeeDTO;
import com.enclave.backend.entity.Employee;
import com.enclave.backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeAPI {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody EmployeeDTO dto){
        Employee newEmployee = employeeService.createEmployee(dto);
        return newEmployee;
    }


}
