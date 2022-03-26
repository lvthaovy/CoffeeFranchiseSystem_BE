package com.enclave.backend.service.impl;

import com.enclave.backend.entity.Branch;
import com.enclave.backend.entity.Employee;
import com.enclave.backend.repository.BranchRepository;
import com.enclave.backend.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    private BranchRepository branchRepository;

    @Override
    public Branch createBranch(String name, String address) {
        Branch branch = new Branch();
        branch.setName(name);
        branch.setAddress(address);
        branch.setStatus("ACTIVE");
        return branchRepository.save(branch);
    }

    @Override
    public Branch updateBranch(short id, String name, String address, String status) {
        Branch oldBranch = branchRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid branch Id:" + id));
        if (name != null) {
            oldBranch.setName(name);
        }
        if (address != null) {
            oldBranch.setAddress(address);
        }
        if (status != null) {
            oldBranch.setStatus(status);
        }
        return branchRepository.save(oldBranch);
    }

    @Override
    public List<Branch> getBranches() {
        return branchRepository.findAll();
    }

    @Override
    public Branch getBranchById(short id) {
        return branchRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Imvalid branch id: " + id));
    }

    public Branch getBranchByEmployee(Employee employee) {
        short branchId = employee.getBranch().getId();
        return branchRepository.findById(branchId).orElseThrow(() -> new IllegalArgumentException("Invalid branch Id"));
    }
}
