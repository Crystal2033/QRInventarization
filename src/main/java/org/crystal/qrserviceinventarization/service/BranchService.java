/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.service;

import jakarta.transaction.Transactional;
import org.crystal.qrserviceinventarization.database.dto.BranchDTO;
import org.crystal.qrserviceinventarization.database.mapper.BranchMapper;
import org.crystal.qrserviceinventarization.exception.ResourceNotFoundException;
import org.crystal.qrserviceinventarization.repository.BranchRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;

@Service
public class BranchService {
    private final BranchRepository branchRepository;
    private final BranchMapper branchMapper;

    @Autowired
    public BranchService(BranchRepository branchRepository, BranchMapper branchMapper) {
        this.branchRepository = branchRepository;
        this.branchMapper = branchMapper;
    }

    public List<BranchDTO> getBranchesByOrgId(Long orgId) {
        var branches = branchRepository.getBranchesByOrganizationId(orgId);

        if (branches.isEmpty()) {
            throw new ResourceNotFoundException(STR."Branches with organization id = \{orgId} does not exist.");
        }
        var test = branchMapper.toDto(branches.get(0));
        return branches
                .stream()
                .map(branchMapper::toDto)
                .toList();
    }

    public BranchDTO saveBranch(BranchDTO branchDTO) {
        var savedBranch = branchRepository.save(branchMapper.toEntity(branchDTO));
        return branchMapper.toDto(savedBranch);
    }
}
