package com.enclave.backend.service;

import com.enclave.backend.entity.Branch;

import java.util.List;

public interface BranchService {

    Branch createBranch(String name, String address);

    Branch updateBranch(short id, String name, String address);

    List<Branch> getBranchs();
}
