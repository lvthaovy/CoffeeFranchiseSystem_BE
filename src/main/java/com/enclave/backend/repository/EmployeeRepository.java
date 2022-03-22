package com.enclave.backend.repository;

import com.enclave.backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Short> {
    Employee findByUsername(String name);
    Optional<Employee> findById(Short id);
}
