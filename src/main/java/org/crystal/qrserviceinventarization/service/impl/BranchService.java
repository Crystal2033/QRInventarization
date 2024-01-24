/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.service.impl;

import org.crystal.qrserviceinventarization.database.dto.BranchDTO;
import org.crystal.qrserviceinventarization.database.mapper.BranchMapper;
import org.crystal.qrserviceinventarization.exception.ResourceNotFoundException;
import org.crystal.qrserviceinventarization.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public BranchDTO getBranchById(Long branchId) {
        var branch = branchRepository.findById(branchId);

        return branchMapper.toDto(
                branchRepository.save(branch.orElseThrow(()
                        -> new ResourceNotFoundException(STR."Branch with id=\{branchId} can not be found"))));
    }

    public List<BranchDTO> getBranchesByOrgId(Long orgId) {
        var branches = branchRepository.getBranchesByOrganizationId(orgId);

        if (branches.isEmpty()) {
            throw new ResourceNotFoundException(STR."Branches with organization id = \{orgId} does not exist.");
        }
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
