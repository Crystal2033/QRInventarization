/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.controller;

import org.crystal.qrserviceinventarization.database.model.Monitor;
import org.crystal.qrserviceinventarization.database.model.Projector;
import org.crystal.qrserviceinventarization.service.ProjectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/projectors")
public class ProjectorController {
    private final ProjectorService projectorService;

    @Autowired
    public ProjectorController(ProjectorService projectorService) {
        this.projectorService = projectorService;
    }

    @GetMapping("/{cabinetId}")
    public ResponseEntity<List<Projector>> getProjectorsByCabinetId(@PathVariable Long cabinetId){
        return new ResponseEntity<>(projectorService.getProjectorsByCabinetId(cabinetId), HttpStatus.OK);
    }
}
