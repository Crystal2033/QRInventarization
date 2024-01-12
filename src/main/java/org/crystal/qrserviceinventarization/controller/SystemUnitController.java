/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.controller;

import org.crystal.qrserviceinventarization.database.dto.SystemUnitDTO;
import org.crystal.qrserviceinventarization.service.SystemUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<SystemUnitDTO>> getSystemUnitsByCabinetId(@PathVariable(required = false) Long orgId,
                                                                         @PathVariable(required = false) Long branchId,
                                                                         @PathVariable(required = false) Long buildingId,
                                                                         @PathVariable Long cabinetId) {
        return new ResponseEntity<>(systemUnitService.getSystemUnitsByCabinetId(cabinetId), HttpStatus.OK);
    }

    @PostMapping


    public ResponseEntity<SystemUnitDTO> saveSystemUnit(@PathVariable(required = false) Long orgId,
                                                        @PathVariable(required = false) Long branchId,
                                                        @PathVariable(required = false) Long buildingId,
                                                        @PathVariable(required = false) Long cabinetId,
                                                        @RequestBody SystemUnitDTO systemUnitDTO) {
        return new ResponseEntity<>(systemUnitService.saveSystemUnit(systemUnitDTO), HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<SystemUnitDTO> updateSystemUnit(@PathVariable(required = false) Long orgId,
                                                          @PathVariable(required = false) Long branchId,
                                                          @PathVariable(required = false) Long buildingId,
                                                          @PathVariable(required = false) Long cabinetId,
                                                          @RequestBody SystemUnitDTO systemUnitDTO) {
        return new ResponseEntity<>(systemUnitService.saveSystemUnit(systemUnitDTO), HttpStatus.OK);

    }

    @DeleteMapping("/{systemUnitId}")
    public ResponseEntity<Void> deleteSystemUnitById(@PathVariable(required = false) Long orgId,
                                                     @PathVariable(required = false) Long branchId,
                                                     @PathVariable(required = false) Long buildingId,
                                                     @PathVariable(required = false) Long cabinetId,
                                                     @PathVariable Long systemUnitId) {
        systemUnitService.deleteSystemUnitById(systemUnitId);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/{systemUnitId}")
    public ResponseEntity<SystemUnitDTO> getSystemUnitById(@PathVariable(required = false) Long orgId,
                                                           @PathVariable(required = false) Long branchId,
                                                           @PathVariable(required = false) Long buildingId,
                                                           @PathVariable(required = false) Long cabinetId,
                                                           @PathVariable Long systemUnitId) {
        return new ResponseEntity<>(systemUnitService.getSystemUnitById(systemUnitId), HttpStatus.OK);
    }
}
