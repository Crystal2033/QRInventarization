/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 12.01.2024
 */

package org.crystal.qrserviceinventarization.database.mapper;

import jakarta.annotation.PostConstruct;
import org.crystal.qrserviceinventarization.database.dto.AbstractInventarizedObjectMapper;
import org.crystal.qrserviceinventarization.database.dto.DeskDTO;
import org.crystal.qrserviceinventarization.database.model.Desk;
import org.crystal.qrserviceinventarization.repository.CabinetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class DeskMapper extends AbstractInventarizedObjectMapper<Desk, DeskDTO> {

    @Autowired
    DeskMapper(CabinetRepository cabinetRepository) {
        super(Desk.class, DeskDTO.class, cabinetRepository);
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Desk.class, DeskDTO.class)
                .addMappings(m -> m.skip(DeskDTO::setCabinetId)).setPostConverter(toDtoConverter());

        mapper.createTypeMap(DeskDTO.class, Desk.class)
                .addMappings(m -> m.skip(Desk::setCabinet)).setPostConverter(toEntityConverter());
    }

}
