/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.controller;

import org.crystal.qrserviceinventarization.database.model.Chair;
import org.crystal.qrserviceinventarization.service.ChairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/chairs")
public class ChairController {
    private final ChairService chairService;

    @Autowired
    public ChairController(ChairService chairService) {
        this.chairService = chairService;
    }

    @GetMapping("/{cabinetId}")
    public ResponseEntity<List<Chair>> getChairsByCabinetId(@PathVariable Long cabinetId){
        return new ResponseEntity<>(chairService.getChairsByCabinetId(cabinetId), HttpStatus.OK);
    }
}
