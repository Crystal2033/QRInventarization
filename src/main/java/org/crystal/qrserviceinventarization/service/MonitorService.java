/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.service;

import org.crystal.qrserviceinventarization.database.model.Monitor;
import org.crystal.qrserviceinventarization.repository.MonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitorService {
    private final MonitorRepository monitorRepository;

    @Autowired
    public MonitorService(MonitorRepository monitorRepository) {
        this.monitorRepository = monitorRepository;
    }

    public List<Monitor> getMonitorsByCabinetId(Long cabinetId){
        return monitorRepository.findMonitorsByCabinetId(cabinetId);
    }
}
