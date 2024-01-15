/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.service.impl;

import org.crystal.qrserviceinventarization.database.dto.CabinetDTO;
import org.crystal.qrserviceinventarization.database.mapper.CabinetMapper;
import org.crystal.qrserviceinventarization.exception.ResourceNotFoundException;
import org.crystal.qrserviceinventarization.repository.CabinetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CabinetService {
    private final CabinetRepository cabinetRepository;
    private final CabinetMapper cabinetMapper;

    @Autowired
    public CabinetService(CabinetRepository cabinetRepository, CabinetMapper cabinetMapper) {
        this.cabinetRepository = cabinetRepository;
        this.cabinetMapper = cabinetMapper;
    }

    public List<CabinetDTO> getCabinetsByBuildingId(Long buildingId) {
        var cabinets = cabinetRepository.getCabinetsByBuildingId(buildingId);

        if (cabinets.isEmpty()) {
            throw new ResourceNotFoundException(STR."Cabinets with building id = \{buildingId} not found");
        }
        return cabinets
                .stream()
                .map(cabinetMapper::toDto)
                .toList();
    }

    public CabinetDTO saveCabinet(CabinetDTO cabinetDTO) {
        var savedCabinet = cabinetRepository.save(cabinetMapper.toEntity(cabinetDTO));
        return cabinetMapper.toDto(savedCabinet);
    }

//    private Optional<Cabinet> getCabinetById(Long cabinetId){
//        return cabinetRepository.findById(cabinetId);
//    }
}
