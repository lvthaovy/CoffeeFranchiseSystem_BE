package com.enclave.backend.api;

import com.enclave.backend.entity.Branch;
import com.enclave.backend.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branch")
public class BranchAPI {

    @Autowired
    private BranchService branchService;

    @GetMapping("/all")
    public List<Branch> getBranches() {
        return branchService.getBranches();
    }

    @PostMapping("/")
    public Branch createBranch(@RequestBody Branch branch) {
        return branchService.createBranch(branch.getName(), branch.getAddress());
    }

    @PutMapping("/{id}")
    public Branch editBranch(@PathVariable("id") short id, @RequestBody Branch branch) {
        return branchService.updateBranch(id, branch.getName(), branch.getAddress(), branch.getStatus());
    }

    @GetMapping("/{id}")
    public Branch getBranchById(@PathVariable("id") short id) {
        return branchService.getBranchById(id);
    }

}
