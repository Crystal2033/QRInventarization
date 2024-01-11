/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.controller;

import org.crystal.qrserviceinventarization.database.dto.CabinetDTO;
import org.crystal.qrserviceinventarization.service.CabinetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizations/{orgId}/branches/{branchId}/buildings/{buildingId}/cabinets")
public class CabinetController {
    private final CabinetService cabinetService;

    @Autowired
    public CabinetController(CabinetService cabinetService) {
        this.cabinetService = cabinetService;
    }

    @GetMapping
    public ResponseEntity<List<CabinetDTO>> getCabinetsBuildingId(@PathVariable Long orgId,
                                                                  @PathVariable Long branchId,
                                                                  @PathVariable Long buildingId) {
        return new ResponseEntity<>(cabinetService.getCabinetsByBuildingId(buildingId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CabinetDTO> saveCabinet(@PathVariable Long orgId,
                                                  @PathVariable Long branchId,
                                                  @PathVariable Long buildingId,
                                                  @RequestBody CabinetDTO cabinetDTO) {
        return new ResponseEntity<>(cabinetService.saveCabinet(cabinetDTO), HttpStatus.CREATED);
    }
}
