package com.enclave.backend.jwt;

import com.enclave.backend.entity.Employee;
import com.enclave.backend.entity.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {
    Employee employee;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

//        return Collections.singleton(new SimpleGrantedAuthority(employee.getRole().getName()));
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));

    }

    @Override
    public String getPassword() {
        return employee.getPassword();
    }

    @Override
    public String getUsername() {
        return employee.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Employee getUser() {
        return employee;
    }

    public void setUser(Employee employee) {
        this.employee = employee;
    }

    public CustomUserDetails(Employee employee) {
        this.employee = employee;
    }
}
