/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.service;

import org.crystal.qrserviceinventarization.database.model.Branch;
import org.crystal.qrserviceinventarization.database.model.Building;
import org.crystal.qrserviceinventarization.exception.ResourceNotFoundException;
import org.crystal.qrserviceinventarization.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static java.lang.StringTemplate.STR;

@Service
public class BranchService {
    private final BranchRepository branchRepository;

    @Autowired
    public BranchService(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    public List<Branch> getBranchesByOrgId(Long orgId){
        var branches = branchRepository.getBranchesByOrganizationId(orgId);
        if (branches.isEmpty()){
            throw new ResourceNotFoundException(STR."Branches with organization id = \{orgId} does not exist.");
        }
        return branches;
    }
}
