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
    private EmployeeRepository employeeRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private EmployeeConverter employeeConverter;

    @Autowired
    private BCryptPasswordEncoder passwordEncode;

    @Override
    public Employee createEmployee(EmployeeDTO dto) {
        short branchId = dto.getBranchId();
        Branch branch = branchRepository.findById(branchId).orElseThrow(() -> new IllegalArgumentException("Invalid branch Id:" + branchId));

        short roleId = dto.getRoleId();
        Role role = roleRepository.findById(roleId).orElseThrow(() -> new IllegalArgumentException("Invalid role Id:" + roleId));

        Employee newEmployee = employeeConverter.toEntity(dto);

        newEmployee.setRole(role);
        newEmployee.setBranch(branch);
        newEmployee.setPassword(passwordEncode.encode("123123"));
        newEmployee.setStatus("active");
        employeeRepository.save(newEmployee);
        return employeeRepository.save(newEmployee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {

        short employeeId = employee.getId();
        Employee oldEmployee = employeeRepository.findById(employeeId).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + employeeId));

        short branchId = employee.getBranch().getId();

        Branch branch = branchRepository.findById(branchId).orElseThrow(() -> new IllegalArgumentException("Invalid branch Id:" + branchId));

        oldEmployee.setName(employee.getName());
        oldEmployee.setPhone(employee.getPhone());
        oldEmployee.setBirth(employee.getBirth());
        oldEmployee.setAvatar(employee.getAvatar());
        oldEmployee.setGender(employee.getGender());
        oldEmployee.setAddress(employee.getAddress());
        oldEmployee.setUsername(employee.getUsername());
        oldEmployee.setBranch(branch);
        oldEmployee.setPassword(passwordEncode.encode(employee.getPassword()));
        return employeeRepository.save(oldEmployee);
    }

    @Override
    public Employee getEmployeeById(short id) {
        return employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee user = employeeRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }

//		return new User(user.getUsername(), user.getPassword(), authorities);
        return new CustomUserDetails(user);
    }

    @Transactional
    public UserDetails loadUserById(Short id) {
        Optional<Employee> optionalUser = employeeRepository.findById(id);
        Employee user = optionalUser.get();
        if (user == null) {
            throw new UsernameNotFoundException("user not found: " + id);
        }
        return new CustomUserDetails(user);
    }

}
