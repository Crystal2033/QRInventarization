/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 11.01.2024
 */

package org.crystal.qrserviceinventarization.database.mapper;

import jakarta.annotation.PostConstruct;
import org.crystal.qrserviceinventarization.database.dto.AbstractInventarizedObjectMapper;
import org.crystal.qrserviceinventarization.database.dto.ChairDTO;
import org.crystal.qrserviceinventarization.database.model.Chair;
import org.crystal.qrserviceinventarization.repository.CabinetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class ChairMapper extends AbstractInventarizedObjectMapper<Chair, ChairDTO> {

    @Autowired
    ChairMapper(CabinetRepository cabinetRepository) {
        super(Chair.class, ChairDTO.class, cabinetRepository);
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Chair.class, ChairDTO.class)
                .addMappings(m -> m.skip(ChairDTO::setCabinetId)).setPostConverter(toDtoConverter());

        mapper.createTypeMap(ChairDTO.class, Chair.class)
                .addMappings(m -> m.skip(Chair::setCabinet)).setPostConverter(toEntityConverter());
    }
}
