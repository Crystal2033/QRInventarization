/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.controller;

import org.crystal.qrserviceinventarization.database.dto.DeskDTO;
import org.crystal.qrserviceinventarization.service.impl.DeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizations/{orgId}/branches/{branchId}/buildings/{buildingId}/cabinets/{cabinetId}/desks")
public class DeskController {
    private final DeskService deskService;

    @Autowired
    public DeskController(DeskService deskService) {
        this.deskService = deskService;
    }

    @GetMapping
    public ResponseEntity<List<DeskDTO>> getDesksByCabinetId(@PathVariable(required = false) Long orgId,
                                                             @PathVariable(required = false) Long branchId,
                                                             @PathVariable(required = false) Long buildingId,
                                                             @PathVariable Long cabinetId) {
        return new ResponseEntity<>(deskService.getDesksByCabinetId(cabinetId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DeskDTO> saveDesk(@PathVariable(required = false) Long orgId,
                                            @PathVariable(required = false) Long branchId,
                                            @PathVariable(required = false) Long buildingId,
                                            @PathVariable(required = false) Long cabinetId,
                                            @RequestBody DeskDTO deskDTO) {
        return new ResponseEntity<>(deskService.saveDesk(deskDTO), HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<DeskDTO> updateDesk(@PathVariable(required = false) Long orgId,
                                              @PathVariable(required = false) Long branchId,
                                              @PathVariable(required = false) Long buildingId,
                                              @PathVariable(required = false) Long cabinetId,
                                              @RequestBody DeskDTO deskDTO) {
        return new ResponseEntity<>(deskService.saveDesk(deskDTO), HttpStatus.OK);

    }

    @DeleteMapping("/{deskId}")
    public ResponseEntity<Void> deleteDeskById(@PathVariable(required = false) Long orgId,
                                               @PathVariable(required = false) Long branchId,
                                               @PathVariable(required = false) Long buildingId,
                                               @PathVariable(required = false) Long cabinetId,
                                               @PathVariable Long deskId) {
        deskService.deleteDeskById(deskId);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/{deskId}")
    public ResponseEntity<DeskDTO> getDeskById(@PathVariable(required = false) Long orgId,
                                               @PathVariable(required = false) Long branchId,
                                               @PathVariable(required = false) Long buildingId,
                                               @PathVariable(required = false) Long cabinetId,
                                               @PathVariable Long deskId) {
        return new ResponseEntity<>(deskService.getDeskById(deskId), HttpStatus.OK);
    }
}
