/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.controller;

import org.crystal.qrserviceinventarization.database.dto.ProjectorDTO;
import org.crystal.qrserviceinventarization.service.impl.ProjectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
                                                                       @PathVariable Long cabinetId) {
        return new ResponseEntity<>(projectorService.getProjectorsByCabinetId(cabinetId), HttpStatus.OK);
    }

    @PostMapping


    public ResponseEntity<ProjectorDTO> saveProjector(@PathVariable(required = false) Long orgId,
                                                      @PathVariable(required = false) Long branchId,
                                                      @PathVariable(required = false) Long buildingId,
                                                      @PathVariable(required = false) Long cabinetId,
                                                      @RequestBody ProjectorDTO projectorDTO) {
        return new ResponseEntity<>(projectorService.saveProjector(projectorDTO), HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<ProjectorDTO> updateProjector(@PathVariable(required = false) Long orgId,
                                                        @PathVariable(required = false) Long branchId,
                                                        @PathVariable(required = false) Long buildingId,
                                                        @PathVariable(required = false) Long cabinetId,
                                                        @RequestBody ProjectorDTO projectorDTO) {
        return new ResponseEntity<>(projectorService.saveProjector(projectorDTO), HttpStatus.OK);

    }

    @DeleteMapping("/{projectorId}")
    public ResponseEntity<Void> deleteProjectorById(@PathVariable(required = false) Long orgId,
                                                    @PathVariable(required = false) Long branchId,
                                                    @PathVariable(required = false) Long buildingId,
                                                    @PathVariable(required = false) Long cabinetId,
                                                    @PathVariable Long projectorId) {
        projectorService.deleteProjectorById(projectorId);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/{projectorId}")
    public ResponseEntity<ProjectorDTO> getProjectorById(@PathVariable(required = false) Long orgId,
                                                         @PathVariable(required = false) Long branchId,
                                                         @PathVariable(required = false) Long buildingId,
                                                         @PathVariable(required = false) Long cabinetId,
                                                         @PathVariable Long projectorId) {
        return new ResponseEntity<>(projectorService.getProjectorById(projectorId), HttpStatus.OK);
    }
}
