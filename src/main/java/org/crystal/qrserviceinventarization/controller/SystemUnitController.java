/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.controller;

import org.crystal.qrserviceinventarization.database.dto.SystemUnitDTO;
import org.crystal.qrserviceinventarization.database.model.SystemUnit;
import org.crystal.qrserviceinventarization.service.SystemUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/organizations/{orgId}/branches/{branchId}/buildings/{buildingId}/cabinets/{cabinetId}/system_units")
public class SystemUnitController {
    private final SystemUnitService systemUnitService;

    @Autowired
    public SystemUnitController(SystemUnitService systemUnitService) {
        this.systemUnitService = systemUnitService;
    }

    @GetMapping
    public ResponseEntity<List<SystemUnitDTO>> getSystemUnitsByCabinetId(@PathVariable Long orgId,
                                                                         @PathVariable Long branchId,
                                                                         @PathVariable Long buildingId,
                                                                         @PathVariable Long cabinetId) {
        return new ResponseEntity<>(systemUnitService.getSystemUnitsByCabinetId(cabinetId), HttpStatus.OK);
    }
}
