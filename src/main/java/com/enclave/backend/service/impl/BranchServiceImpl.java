package com.enclave.backend.service.impl;

import com.enclave.backend.entity.Branch;
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
        return branchRepository.save(branch);
    }

    @Override
    public Branch updateBranch(short id, String name, String address) {
        Branch oldBranch = branchRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid branch Id:" + id));
        oldBranch.setName(name);
        oldBranch.setAddress(address);
        return branchRepository.save(oldBranch);
    }

    @Override
    public List<Branch> getBranchs() {
        return branchRepository.findAll();
    }
}
