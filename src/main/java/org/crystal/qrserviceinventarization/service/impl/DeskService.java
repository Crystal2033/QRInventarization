/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.service.impl;

import org.crystal.qrserviceinventarization.database.dto.DeskDTO;
import org.crystal.qrserviceinventarization.database.mapper.DeskMapper;
import org.crystal.qrserviceinventarization.exception.ResourceNotFoundException;
import org.crystal.qrserviceinventarization.repository.DeskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeskService {
    private final DeskRepository deskRepository;

    private final DeskMapper deskMapper;

    @Autowired
    public DeskService(DeskRepository deskRepository, DeskMapper deskMapper) {
        this.deskRepository = deskRepository;
        this.deskMapper = deskMapper;
    }

    public List<DeskDTO> getDesksByCabinetId(Long cabinetId) {
        var desks = deskRepository.findDesksByCabinetId(cabinetId);
        if (desks.isEmpty()) {
            throw new ResourceNotFoundException(STR."Desks with cabinet id = \{cabinetId} not found");
        }
        return desks
                .stream()
                .map(deskMapper::toDto)
                .toList();
    }

    public DeskDTO saveDesk(DeskDTO deskDTO) {
        var savedDesk = deskRepository.save(deskMapper.toEntity(deskDTO));
        return deskMapper.toDto(savedDesk);
    }

    public DeskDTO getDeskById(Long deskId) {
        var desk = deskRepository.findById(deskId).orElseThrow(
                () -> new ResourceNotFoundException(STR."Desk with id= \{deskId} not found")
        );
        return deskMapper.toDto(desk);
    }

    public void deleteDeskById(Long deskId) {
        var desk = deskRepository.findById(deskId).orElseThrow(
                () -> new ResourceNotFoundException(STR."Desk with id= \{deskId} not found")
        );

        deskRepository.delete(desk);
    }
}
