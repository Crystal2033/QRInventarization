/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.service;

import org.crystal.qrserviceinventarization.database.dto.ChairDTO;
import org.crystal.qrserviceinventarization.database.mapper.ChairMapper;
import org.crystal.qrserviceinventarization.database.model.Chair;
import org.crystal.qrserviceinventarization.exception.ResourceNotFoundException;
import org.crystal.qrserviceinventarization.repository.CabinetRepository;
import org.crystal.qrserviceinventarization.repository.ChairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChairService {
    private final ChairRepository chairRepository;
    private final CabinetRepository cabinetRepository;

    private final ChairMapper chairMapper;

    @Autowired
    public ChairService(ChairRepository chairRepository, CabinetRepository cabinetRepository, ChairMapper chairMapper) {
        this.chairRepository = chairRepository;
        this.cabinetRepository = cabinetRepository;
        this.chairMapper = chairMapper;
    }

    public List<ChairDTO> getChairsByCabinetId(Long cabinetId) {
        var chairs = chairRepository.findChairsByCabinetId(cabinetId);
        if (chairs.isEmpty()) {
            throw new ResourceNotFoundException(STR."Chairs with cabinet id = \{cabinetId} not found");
        }
        return chairs
                .stream()
                .map(chairMapper::toDto)
                .toList();
    }

    public ChairDTO saveChair(ChairDTO chairDTO, Long cabinetId) {
        var savedChair = chairRepository.save(chairMapper.toEntity(chairDTO));
        return chairMapper.toDto(savedChair);
    }
}
