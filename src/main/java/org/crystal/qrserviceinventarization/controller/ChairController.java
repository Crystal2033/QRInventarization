/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.controller;

import org.crystal.qrserviceinventarization.database.dto.ChairDTO;
import org.crystal.qrserviceinventarization.service.ChairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizations/{orgId}/branches/{branchId}/buildings/{buildingId}/cabinets/{cabinetId}/chairs")
public class ChairController {
    private final ChairService chairService;

    @Autowired
    public ChairController(ChairService chairService) {
        this.chairService = chairService;
    }

    @GetMapping
    public ResponseEntity<List<ChairDTO>> getChairsByCabinetId(@PathVariable Long orgId,
                                                               @PathVariable Long branchId,
                                                               @PathVariable Long buildingId,
                                                               @PathVariable Long cabinetId) {
        return new ResponseEntity<>(chairService.getChairsByCabinetId(cabinetId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ChairDTO> saveChair(@PathVariable Long orgId,
                                              @PathVariable Long branchId,
                                              @PathVariable Long buildingId,
                                              @PathVariable Long cabinetId,
                                              @RequestBody ChairDTO chair) {
        return new ResponseEntity<>(chairService.saveChair(chair, cabinetId), HttpStatus.CREATED);

    }
}
