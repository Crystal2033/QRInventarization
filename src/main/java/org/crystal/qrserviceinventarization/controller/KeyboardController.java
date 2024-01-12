/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.controller;

import org.apache.catalina.mapper.Mapper;
import org.crystal.qrserviceinventarization.database.dto.KeyboardDTO;
import org.crystal.qrserviceinventarization.database.model.Keyboard;
import org.crystal.qrserviceinventarization.service.KeyboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/organizations/{orgId}/branches/{branchId}/buildings/{buildingId}/cabinets/{cabinetId}/keyboards")
public class KeyboardController {
    private final KeyboardService keyboardService;

    @Autowired
    public KeyboardController(KeyboardService keyboardService) {
        this.keyboardService = keyboardService;
    }

    @GetMapping
    public ResponseEntity<List<KeyboardDTO>> getChairsByCabinetId(@PathVariable Long orgId,
                                                                  @PathVariable Long branchId,
                                                                  @PathVariable Long buildingId,
                                                                  @PathVariable Long cabinetId){
        return new ResponseEntity<>(keyboardService.getKeyboardsByCabinetId(cabinetId), HttpStatus.OK);
    }
}
