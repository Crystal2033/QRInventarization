/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 12.01.2024
 */

package org.crystal.qrserviceinventarization.database.mapper;

import jakarta.annotation.PostConstruct;
import org.crystal.qrserviceinventarization.database.dto.AbstractInventarizedObjectMapper;
import org.crystal.qrserviceinventarization.database.dto.ProjectorDTO;
import org.crystal.qrserviceinventarization.database.dto.SystemUnitDTO;
import org.crystal.qrserviceinventarization.database.model.Projector;
import org.crystal.qrserviceinventarization.database.model.SystemUnit;
import org.crystal.qrserviceinventarization.exception.ResourceNotFoundException;
import org.crystal.qrserviceinventarization.repository.CabinetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SystemUnitMapper extends AbstractInventarizedObjectMapper<SystemUnit, SystemUnitDTO> {

    @Autowired
    protected SystemUnitMapper(CabinetRepository cabinetRepository) {
        super(SystemUnit.class, SystemUnitDTO.class, cabinetRepository);
    }


    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(SystemUnit.class, SystemUnitDTO.class)
                .addMappings(m -> m.skip(SystemUnitDTO::setCabinetId)).setPostConverter(toDtoConverter());

        mapper.createTypeMap(SystemUnitDTO.class, SystemUnit.class)
                .addMappings(m -> m.skip(SystemUnit::setCabinet)).setPostConverter(toEntityConverter());
    }

}
