package com.enclave.backend.api;

import com.enclave.backend.entity.Branch;
import com.enclave.backend.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BranchAPI {
    @Autowired
    private BranchService branchService;

    @GetMapping("/branch")
    public List<Branch> getBranchs() {
        return branchService.getBranchs();
    }

    @PostMapping("/branch")
    public Branch createBranch(@RequestBody Branch branch) {
        return branchService.createBranch(branch.getName(), branch.getAddress());
    }

    @PutMapping("/branch/{id}")
    public Branch editBranch(@PathVariable("id") short id, @RequestBody Branch branch) {
        return branchService.updateBranch(id, branch.getName(), branch.getAddress());
    }
}
