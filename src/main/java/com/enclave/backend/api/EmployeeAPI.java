package com.enclave.backend.api;

import com.enclave.backend.dto.EmployeeDTO;
import com.enclave.backend.entity.Employee;
import com.enclave.backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeAPI {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody EmployeeDTO dto) {
        Employee newEmployee = employeeService.createEmployee(dto);
        return newEmployee;
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable("id") short id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }
}
