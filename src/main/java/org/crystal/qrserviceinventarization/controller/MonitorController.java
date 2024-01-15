/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.controller;

import org.crystal.qrserviceinventarization.database.dto.MonitorDTO;
import org.crystal.qrserviceinventarization.service.impl.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<MonitorDTO>> getMonitorsByCabinetId(@PathVariable(required = false) Long orgId,
                                                                   @PathVariable(required = false) Long branchId,
                                                                   @PathVariable(required = false) Long buildingId,
                                                                   @PathVariable Long cabinetId) {
        return new ResponseEntity<>(monitorService.getMonitorsByCabinetId(cabinetId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MonitorDTO> saveMonitor(@PathVariable(required = false) Long orgId,
                                                  @PathVariable(required = false) Long branchId,
                                                  @PathVariable(required = false) Long buildingId,
                                                  @PathVariable(required = false) Long cabinetId,
                                                  @RequestBody MonitorDTO monitorDTO) {
        return new ResponseEntity<>(monitorService.saveMonitor(monitorDTO), HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<MonitorDTO> updateMonitor(@PathVariable(required = false) Long orgId,
                                                    @PathVariable(required = false) Long branchId,
                                                    @PathVariable(required = false) Long buildingId,
                                                    @PathVariable(required = false) Long cabinetId,
                                                    @RequestBody MonitorDTO monitorDTO) {
        return new ResponseEntity<>(monitorService.saveMonitor(monitorDTO), HttpStatus.OK);

    }

    @DeleteMapping("/{monitorId}")
    public ResponseEntity<Void> deleteMonitorById(@PathVariable(required = false) Long orgId,
                                                  @PathVariable(required = false) Long branchId,
                                                  @PathVariable(required = false) Long buildingId,
                                                  @PathVariable(required = false) Long cabinetId,
                                                  @PathVariable Long monitorId) {
        monitorService.deleteMonitorById(monitorId);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/{monitorId}")
    public ResponseEntity<MonitorDTO> getMonitorById(@PathVariable(required = false) Long orgId,
                                                     @PathVariable(required = false) Long branchId,
                                                     @PathVariable(required = false) Long buildingId,
                                                     @PathVariable(required = false) Long cabinetId,
                                                     @PathVariable Long monitorId) {
        return new ResponseEntity<>(monitorService.getMonitorById(monitorId), HttpStatus.OK);
    }
}
