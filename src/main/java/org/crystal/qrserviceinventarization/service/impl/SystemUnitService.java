/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.service.impl;

import org.crystal.qrserviceinventarization.database.dto.SystemUnitDTO;
import org.crystal.qrserviceinventarization.database.mapper.SystemUnitMapper;
import org.crystal.qrserviceinventarization.exception.ResourceNotFoundException;
import org.crystal.qrserviceinventarization.repository.SystemUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemUnitService {
    private final SystemUnitRepository systemUnitRepository;
    private final SystemUnitMapper systemUnitMapper;

    @Autowired
    public SystemUnitService(SystemUnitRepository systemUnitRepository, SystemUnitMapper systemUnitMapper) {
        this.systemUnitRepository = systemUnitRepository;
        this.systemUnitMapper = systemUnitMapper;
    }

    public List<SystemUnitDTO> getSystemUnitsByCabinetId(Long cabinetId) {
        var systemUnits = systemUnitRepository.findSystemUnitsByCabinetId(cabinetId);
        if (systemUnits.isEmpty()) {
            throw new ResourceNotFoundException(STR."System units with cabinet id = \{cabinetId} not found");
        }
        return systemUnits
                .stream()
                .map(systemUnitMapper::toDto)
                .toList();
    }

    public SystemUnitDTO saveSystemUnit(SystemUnitDTO systemUnitDTO) {
        var savedSystemUnit = systemUnitRepository.save(systemUnitMapper.toEntity(systemUnitDTO));
        return systemUnitMapper.toDto(savedSystemUnit);
    }

    public SystemUnitDTO getSystemUnitById(Long systemUnitId) {
        var systemUnit = systemUnitRepository.findById(systemUnitId).orElseThrow(
                () -> new ResourceNotFoundException(STR."System unit with id= \{systemUnitId} not found")
        );
        return systemUnitMapper.toDto(systemUnit);
    }

    public void deleteSystemUnitById(Long systemUnitId) {
        var systemUnit = systemUnitRepository.findById(systemUnitId).orElseThrow(
                () -> new ResourceNotFoundException(STR."System unit with id= \{systemUnitId} not found")
        );

        systemUnitRepository.delete(systemUnit);
    }
}
