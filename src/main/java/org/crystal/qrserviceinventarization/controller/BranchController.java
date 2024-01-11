/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.crystal.qrserviceinventarization.database.dto.BranchDTO;
import org.crystal.qrserviceinventarization.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizations/{orgId}/branches")
public class BranchController {
    private final BranchService branchService;

    @Autowired
    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @GetMapping
    public ResponseEntity<List<BranchDTO>> getBranchesByOrganizationId(@PathVariable Long orgId) {
        var branchesDTO = branchService.getBranchesByOrgId(orgId);
        return new ResponseEntity<>(branchesDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BranchDTO> saveBranch(@PathVariable Long orgId, @RequestBody BranchDTO branchDTO) {
        var savedBranchDTO = branchService.saveBranch(branchDTO);
        return new ResponseEntity<>(savedBranchDTO, HttpStatus.CREATED);
    }
}
