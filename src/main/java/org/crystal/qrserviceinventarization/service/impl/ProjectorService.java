/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.service.impl;

import org.crystal.qrserviceinventarization.database.dto.ProjectorDTO;
import org.crystal.qrserviceinventarization.database.mapper.ProjectorMapper;
import org.crystal.qrserviceinventarization.exception.ResourceNotFoundException;
import org.crystal.qrserviceinventarization.repository.ProjectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectorService {
    private final ProjectorRepository projectorRepository;

    private final ProjectorMapper projectorMapper;

    @Autowired
    public ProjectorService(ProjectorRepository projectorRepository, ProjectorMapper projectorMapper) {
        this.projectorRepository = projectorRepository;
        this.projectorMapper = projectorMapper;
    }

    public List<ProjectorDTO> getProjectorsByCabinetId(Long cabinetId) {
        var projectors = projectorRepository.findProjectorsByCabinetId(cabinetId);
        if (projectors.isEmpty()) {
            throw new ResourceNotFoundException(STR."Projectors with cabinet id = \{cabinetId} not found");
        }
        return projectors
                .stream()
                .map(projectorMapper::toDto)
                .toList();
    }

    public ProjectorDTO saveProjector(ProjectorDTO projectorDTO) {
        var savedProjector = projectorRepository.save(projectorMapper.toEntity(projectorDTO));
        return projectorMapper.toDto(savedProjector);
    }

    public ProjectorDTO getProjectorById(Long projectorId) {
        var projector = projectorRepository.findById(projectorId).orElseThrow(
                () -> new ResourceNotFoundException(STR."Projector with id= \{projectorId} not found")
        );
        return projectorMapper.toDto(projector);
    }

    public void deleteProjectorById(Long projectorId) {
        var projector = projectorRepository.findById(projectorId).orElseThrow(
                () -> new ResourceNotFoundException(STR."Projector with id= \{projectorId} not found")
        );

        projectorRepository.delete(projector);
    }
}
