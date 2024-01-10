/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.controller;

import org.crystal.qrserviceinventarization.database.model.Chair;
import org.crystal.qrserviceinventarization.database.model.Keyboard;
import org.crystal.qrserviceinventarization.service.KeyboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/keyboards")
public class KeyboardController {
    private final KeyboardService keyboardService;

    @Autowired
    public KeyboardController(KeyboardService keyboardService) {
        this.keyboardService = keyboardService;
    }

    @GetMapping("/{cabinetId}")
    public ResponseEntity<List<Keyboard>> getChairsByCabinetId(@PathVariable Long cabinetId){
        return new ResponseEntity<>(keyboardService.getKeyboardsByCabinetId(cabinetId), HttpStatus.OK);
    }
}
