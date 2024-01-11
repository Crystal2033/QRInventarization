/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.controller;

import org.crystal.qrserviceinventarization.database.model.Desk;
import org.crystal.qrserviceinventarization.service.DeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<List<Desk>> getTablesByCabinetId(@PathVariable Long orgId,
                                                           @PathVariable Long branchId,
                                                           @PathVariable Long buildingId,
                                                           @PathVariable Long cabinetId) {
        return new ResponseEntity<>(deskService.getDesksByCabinetId(cabinetId), HttpStatus.OK);
    }
}
