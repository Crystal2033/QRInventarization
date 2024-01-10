/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.controller;

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
@RequestMapping("/api/system_units")
public class SystemUnitController {
    private final SystemUnitService systemUnitService;

    @Autowired
    public SystemUnitController(SystemUnitService systemUnitService) {
        this.systemUnitService = systemUnitService;
    }

    @GetMapping("/{cabinetId}")
    public ResponseEntity<List<SystemUnit>> getSystemUnitsByCabinetId(@PathVariable Long cabinetId) {
        return new ResponseEntity<>(systemUnitService.getSystemUnitsByCabinetId(cabinetId), HttpStatus.OK);
    }
}
