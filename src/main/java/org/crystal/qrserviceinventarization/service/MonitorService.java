/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.service;

import org.crystal.qrserviceinventarization.database.dto.MonitorDTO;
import org.crystal.qrserviceinventarization.database.mapper.MonitorMapper;
import org.crystal.qrserviceinventarization.exception.ResourceNotFoundException;
import org.crystal.qrserviceinventarization.repository.MonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitorService {
    private final MonitorRepository monitorRepository;

    private final MonitorMapper monitorMapper;

    @Autowired
    public MonitorService(MonitorRepository monitorRepository, MonitorMapper monitorMapper) {
        this.monitorRepository = monitorRepository;
        this.monitorMapper = monitorMapper;
    }

    public List<MonitorDTO> getMonitorsByCabinetId(Long cabinetId) {
        var monitors = monitorRepository.findMonitorsByCabinetId(cabinetId);
        if (monitors.isEmpty()) {
            throw new ResourceNotFoundException(STR."Monitors with cabinet id = \{cabinetId} not found");
        }
        return monitors
                .stream()
                .map(monitorMapper::toDto)
                .toList();
    }

    public MonitorDTO saveMonitor(MonitorDTO monitorDTO) {
        var savedKeyboard = monitorRepository.save(monitorMapper.toEntity(monitorDTO));
        return monitorMapper.toDto(savedKeyboard);
    }

    public MonitorDTO getMonitorById(Long monitorId) {
        var monitor = monitorRepository.findById(monitorId).orElseThrow(
                () -> new ResourceNotFoundException(STR."Monitor with id= \{monitorId} not found")
        );
        return monitorMapper.toDto(monitor);
    }

    public void deleteMonitorById(Long monitorId) {
        var monitor = monitorRepository.findById(monitorId).orElseThrow(
                () -> new ResourceNotFoundException(STR."Monitor with id= \{monitorId} not found")
        );

        monitorRepository.delete(monitor);
    }


}
