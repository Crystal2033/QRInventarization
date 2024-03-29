/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 11.01.2024
 */

package org.crystal.qrserviceinventarization.database.mapper;

import jakarta.annotation.PostConstruct;
import org.crystal.qrserviceinventarization.database.dto.CabinetDTO;
import org.crystal.qrserviceinventarization.database.model.Cabinet;
import org.crystal.qrserviceinventarization.exception.ResourceNotFoundException;
import org.crystal.qrserviceinventarization.repository.BuildingRepository;
import org.springframework.stereotype.Component;

@Component
public final class CabinetMapper extends AbstractMapper<Cabinet, CabinetDTO> {

    private final BuildingRepository buildingRepository;

    CabinetMapper(EntityDtoMapper mapper, BuildingRepository buildingRepository) {
        super(Cabinet.class, CabinetDTO.class);
        this.buildingRepository = buildingRepository;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Cabinet.class, CabinetDTO.class)
                .addMappings(m -> m.skip(CabinetDTO::setBuildingId)).setPostConverter(toDtoConverter());

        mapper.createTypeMap(CabinetDTO.class, Cabinet.class)
                .addMappings(m -> m.skip(Cabinet::setBuilding)).setPostConverter(toEntityConverter());
    }

    @Override
    protected void mapSpecificFieldsEntityToDto(Cabinet source, CabinetDTO destination) {
        destination.setBuildingId(source.getBuilding().getId());
    }

    @Override
    protected void mapSpecificFieldsDtoToEntity(CabinetDTO source, Cabinet destination) {
        destination.setBuilding(buildingRepository.findById(source.getBuildingId())
                .orElseThrow(() -> new ResourceNotFoundException(STR."Building with id = \{source.getBuildingId()} not found")));
    }
}
