/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.service.impl;

import org.crystal.qrserviceinventarization.database.dto.BuildingDTO;
import org.crystal.qrserviceinventarization.database.mapper.BuildingMapper;
import org.crystal.qrserviceinventarization.exception.ResourceNotFoundException;
import org.crystal.qrserviceinventarization.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService {
    private final BuildingRepository buildingRepository;

    private final BuildingMapper buildingMapper;

    @Autowired
    public BuildingService(BuildingRepository buildingRepository, BuildingMapper buildingMapper) {
        this.buildingRepository = buildingRepository;
        this.buildingMapper = buildingMapper;
    }

    public List<BuildingDTO> getBuildingsByBranchId(Long branchId) {
        var buildings = buildingRepository.getBuildingsByBranchId(branchId);

        if (buildings.isEmpty()) {
            throw new ResourceNotFoundException(STR."Buildings with branch id = \{branchId} not found");
        }
        return buildings
                .stream()
                .map(buildingMapper::toDto)
                .toList();
    }

    public BuildingDTO getBuildingById(Long buildingId) {
        var building = buildingRepository.findById(buildingId);

        return buildingMapper.toDto(
                buildingRepository.save(building.orElseThrow(()
                        -> new ResourceNotFoundException(STR."Building with id=\{buildingId} can not be found"))));
    }

    public BuildingDTO saveBuilding(BuildingDTO buildingDTO) {
        var savedBuilding = buildingRepository.save(buildingMapper.toEntity(buildingDTO));
        return buildingMapper.toDto(savedBuilding);
    }
}
