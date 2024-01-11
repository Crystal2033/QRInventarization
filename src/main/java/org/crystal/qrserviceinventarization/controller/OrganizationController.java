/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.crystal.qrserviceinventarization.database.dto.OrganizationDTO;
import org.crystal.qrserviceinventarization.database.mapper.OrganizationMapper;
import org.crystal.qrserviceinventarization.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping
    public ResponseEntity<List<OrganizationDTO>> getAllOrganizations() {
        var organizationsDTO = organizationService.getAllOrganizations();
        return new ResponseEntity<>(organizationsDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrganizationDTO> saveOrganization(@RequestBody OrganizationDTO organizationDTO) {
        var savedOrganizationDTO = organizationService.saveOrganization(organizationDTO);
        return new ResponseEntity<>(savedOrganizationDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/{orgId}")
    public void deleteOrganization(@PathVariable Long orgId) {
        organizationService.deleteOrganizationById(orgId);
    }
}
