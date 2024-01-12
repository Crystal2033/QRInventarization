/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 11.01.2024
 */

package org.crystal.qrserviceinventarization.database.mapper;

import jakarta.annotation.PostConstruct;
import org.crystal.qrserviceinventarization.database.dto.BuildingDTO;
import org.crystal.qrserviceinventarization.database.model.Building;
import org.crystal.qrserviceinventarization.exception.ResourceNotFoundException;
import org.crystal.qrserviceinventarization.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuildingMapper extends AbstractMapper<Building, BuildingDTO> {

    private final BranchRepository branchRepository;

    @Autowired
    BuildingMapper(BranchRepository branchRepository) {
        super(Building.class, BuildingDTO.class);
        this.branchRepository = branchRepository;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Building.class, BuildingDTO.class)
                .addMappings(
                        m -> m.skip(BuildingDTO::setBranchId)).setPostConverter(toDtoConverter());

        mapper.createTypeMap(BuildingDTO.class, Building.class)
                .addMappings(
                        m -> m.skip(Building::setBranch)).setPostConverter(toEntityConverter());
    }

    @Override
    void mapSpecificFieldsEntityToDto(Building source, BuildingDTO destination) {
        destination.setBranchId(source.getBranch().getId());
    }

    @Override
    void mapSpecificFieldsDtoToEntity(BuildingDTO source, Building destination) {
        destination.setBranch(branchRepository.findById(source.getBranchId())
                .orElseThrow(() -> new ResourceNotFoundException(STR."Branch with id = \{source.getBranchId()} not found")));
    }
}
