package com.enclave.backend.service.impl;

import com.enclave.backend.converter.EmployeeConverter;
import com.enclave.backend.dto.EmployeeDTO;
import com.enclave.backend.entity.Branch;
import com.enclave.backend.entity.Employee;
import com.enclave.backend.entity.Role;
import com.enclave.backend.jwt.CustomUserDetails;
import com.enclave.backend.repository.BranchRepository;
import com.enclave.backend.repository.EmployeeRepository;
import com.enclave.backend.repository.RoleRepository;
import com.enclave.backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BranchRepository branchRepository;

    @Autowired
    EmployeeConverter employeeConverter;

    @Autowired
    private BCryptPasswordEncoder passwordEncode;

    @Override
    public Employee createEmployee(EmployeeDTO dto) {
        Branch branch = branchRepository.findById(dto.getBranchId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid branch Id:" + dto.getBranchId()));
        Role role = roleRepository.findById(dto.getRoleId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid role Id:" + dto.getRoleId()));

        Employee newEmployee = employeeConverter.toEntity(dto);
            newEmployee.setRole(role);
            newEmployee.setBranch(branch);
            newEmployee.setPassword(passwordEncode.encode(dto.getPassword()));
            employeeRepository.save(newEmployee);
        return newEmployee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Employee oldEmployee = employeeRepository.findById(employee.getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + employee.getId()));


        return null;
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee user = employeeRepository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }

//		return new User(user.getUsername(), user.getPassword(), authorities);
        return new CustomUserDetails(user);
    }
    @Transactional
    public UserDetails loadUserById(Short id) {
        Optional<Employee> optionalUser = employeeRepository.findById(id);
        Employee user = optionalUser.get();
        if(user == null) {
            throw	new UsernameNotFoundException("user not found: " + id);
        }
        return new CustomUserDetails(user);
    }
}
