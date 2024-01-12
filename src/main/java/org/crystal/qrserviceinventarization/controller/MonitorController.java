/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.controller;

import org.crystal.qrserviceinventarization.database.dto.MonitorDTO;
import org.crystal.qrserviceinventarization.database.model.Monitor;
import org.crystal.qrserviceinventarization.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/organizations/{orgId}/branches/{branchId}/buildings/{buildingId}/cabinets/{cabinetId}/monitors")
public class MonitorController {
    private final MonitorService monitorService;

    @Autowired
    public MonitorController(MonitorService monitorService) {
        this.monitorService = monitorService;
    }

    @GetMapping
    public ResponseEntity<List<MonitorDTO>> getMonitorsByCabinetId(@PathVariable Long orgId,
                                                                   @PathVariable Long branchId,
                                                                   @PathVariable Long buildingId,
                                                                   @PathVariable Long cabinetId) {
        return new ResponseEntity<>(monitorService.getMonitorsByCabinetId(cabinetId), HttpStatus.OK);
    }
}
