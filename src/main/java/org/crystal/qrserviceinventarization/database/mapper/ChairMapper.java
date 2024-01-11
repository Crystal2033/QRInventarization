/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 11.01.2024
 */

package org.crystal.qrserviceinventarization.database.mapper;

import jakarta.annotation.PostConstruct;
import org.crystal.qrserviceinventarization.database.dto.ChairDTO;
import org.crystal.qrserviceinventarization.database.model.Chair;
import org.crystal.qrserviceinventarization.exception.ResourceNotFoundException;
import org.crystal.qrserviceinventarization.repository.CabinetRepository;
import org.springframework.stereotype.Component;

@Component
public class ChairMapper extends AbstractMapper<Chair, ChairDTO> {

    private final EntityDtoMapper mapper;
    private final CabinetRepository cabinetRepository;

    ChairMapper(EntityDtoMapper mapper, CabinetRepository cabinetRepository) {
        super(Chair.class, ChairDTO.class);
        this.mapper = mapper;
        this.cabinetRepository = cabinetRepository;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.getModelMapper().createTypeMap(Chair.class, ChairDTO.class)
                .addMappings(m -> m.skip(ChairDTO::setCabinetId)).setPostConverter(toDtoConverter());

        mapper.getModelMapper().createTypeMap(ChairDTO.class, Chair.class)
                .addMappings(m -> m.skip(Chair::setCabinet)).setPostConverter(toEntityConverter());
    }

    @Override
    void mapSpecificFieldsEntityToDto(Chair source, ChairDTO destination) {
        destination.setCabinetId(source.getCabinet().getId());
    }

    @Override
    void mapSpecificFieldsDtoToEntity(ChairDTO source, Chair destination) {
        destination.setCabinet(
                cabinetRepository.findById(source.getCabinetId()).orElseThrow(
                        () -> new ResourceNotFoundException(STR."Cabinet with id = \{source.getCabinetId()} not found")));
    }
}
