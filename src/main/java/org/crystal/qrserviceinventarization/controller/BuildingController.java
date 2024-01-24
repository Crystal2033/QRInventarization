/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.controller;

import org.crystal.qrserviceinventarization.database.dto.BuildingDTO;
import org.crystal.qrserviceinventarization.service.impl.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizations/{orgId}/branches/{branchId}/buildings")
public class BuildingController {
    private final BuildingService buildingService;


    @Autowired
    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    @GetMapping
    public ResponseEntity<List<BuildingDTO>> getBuildingsByBranchId(@PathVariable(required = false) Long orgId,
                                                                    @PathVariable Long branchId) {
        var buildingsDTO = buildingService.getBuildingsByBranchId(branchId);
        return new ResponseEntity<>(buildingsDTO, HttpStatus.OK);
    }

    @GetMapping("/{buildingId}")
    public ResponseEntity<BuildingDTO> getBuildingById(@PathVariable(required = false) Long orgId,
                                                       @PathVariable(required = false) Long branchId,
                                                       @PathVariable Long buildingId) {
        var buildingDTO = buildingService.getBuildingById(buildingId);
        return new ResponseEntity<>(buildingDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BuildingDTO> saveBuilding(@PathVariable(required = false) Long orgId,
                                                    @PathVariable(required = false) Long branchId,
                                                    @RequestBody BuildingDTO buildingDTO) {
        var savedBuildingDTO = buildingService.saveBuilding(buildingDTO);
        return new ResponseEntity<>(savedBuildingDTO, HttpStatus.CREATED);
    }
}
