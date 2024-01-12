/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.controller;

import org.crystal.qrserviceinventarization.database.dto.ProjectorDTO;
import org.crystal.qrserviceinventarization.service.ProjectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/organizations/{orgId}/branches/{branchId}/buildings/{buildingId}/cabinets/{cabinetId}/projectors")
public class ProjectorController {
    private final ProjectorService projectorService;

    @Autowired
    public ProjectorController(ProjectorService projectorService) {
        this.projectorService = projectorService;
    }

    @GetMapping
    public ResponseEntity<List<ProjectorDTO>> getProjectorsByCabinetId(@PathVariable(required = false) Long orgId,
                                                                       @PathVariable(required = false) Long branchId,
                                                                       @PathVariable(required = false) Long buildingId,
                                                                       @PathVariable(required = false) Long cabinetId) {
        return new ResponseEntity<>(projectorService.getProjectorsByCabinetId(cabinetId), HttpStatus.OK);
    }
}
