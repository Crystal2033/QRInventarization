/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.service;

import org.crystal.qrserviceinventarization.database.model.Branch;
import org.crystal.qrserviceinventarization.database.model.Building;
import org.crystal.qrserviceinventarization.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {
    private final BranchRepository branchRepository;

    @Autowired
    public BranchService(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    public List<Branch> getBranchesByOrgId(Long orgId){
        return branchRepository.getBranchesByOrganizationId(orgId);

    }
}
