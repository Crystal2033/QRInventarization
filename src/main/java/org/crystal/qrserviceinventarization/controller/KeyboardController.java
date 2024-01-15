/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.controller;

import org.crystal.qrserviceinventarization.database.dto.KeyboardDTO;
import org.crystal.qrserviceinventarization.service.impl.KeyboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<KeyboardDTO>> getKeyboardsByCabinetId(@PathVariable(required = false) Long orgId,
                                                                     @PathVariable(required = false) Long branchId,
                                                                     @PathVariable(required = false) Long buildingId,
                                                                     @PathVariable Long cabinetId) {
        return new ResponseEntity<>(keyboardService.getKeyboardsByCabinetId(cabinetId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<KeyboardDTO> saveKeyboard(@PathVariable(required = false) Long orgId,
                                                    @PathVariable(required = false) Long branchId,
                                                    @PathVariable(required = false) Long buildingId,
                                                    @PathVariable(required = false) Long cabinetId,
                                                    @RequestBody KeyboardDTO keyboardDTO) {
        return new ResponseEntity<>(keyboardService.saveKeyboard(keyboardDTO), HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<KeyboardDTO> updateKeyboard(@PathVariable(required = false) Long orgId,
                                                      @PathVariable(required = false) Long branchId,
                                                      @PathVariable(required = false) Long buildingId,
                                                      @PathVariable(required = false) Long cabinetId,
                                                      @RequestBody KeyboardDTO keyboardDTO) {
        return new ResponseEntity<>(keyboardService.saveKeyboard(keyboardDTO), HttpStatus.OK);

    }

    @DeleteMapping("/{keyboardId}")
    public ResponseEntity<Void> deleteKeyboardById(@PathVariable(required = false) Long orgId,
                                                   @PathVariable(required = false) Long branchId,
                                                   @PathVariable(required = false) Long buildingId,
                                                   @PathVariable(required = false) Long cabinetId,
                                                   @PathVariable Long keyboardId) {
        keyboardService.deleteKeyboardById(keyboardId);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/{keyboardId}")
    public ResponseEntity<KeyboardDTO> getKeyboardById(@PathVariable(required = false) Long orgId,
                                                       @PathVariable(required = false) Long branchId,
                                                       @PathVariable(required = false) Long buildingId,
                                                       @PathVariable(required = false) Long cabinetId,
                                                       @PathVariable Long keyboardId) {
        return new ResponseEntity<>(keyboardService.getKeyboardById(keyboardId), HttpStatus.OK);
    }
}
