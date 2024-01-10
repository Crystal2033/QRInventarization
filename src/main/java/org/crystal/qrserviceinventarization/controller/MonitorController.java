/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.controller;

import org.crystal.qrserviceinventarization.database.model.Keyboard;
import org.crystal.qrserviceinventarization.database.model.Monitor;
import org.crystal.qrserviceinventarization.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/monitors")
public class MonitorController {
    private final MonitorService monitorService;

    @Autowired
    public MonitorController(MonitorService monitorService) {
        this.monitorService = monitorService;
    }

    @GetMapping("/{cabinetId}")
    public ResponseEntity<List<Monitor>> getMonitorsByCabinetId(@PathVariable Long cabinetId){
        return new ResponseEntity<>(monitorService.getMonitorsByCabinetId(cabinetId), HttpStatus.OK);
    }
}
