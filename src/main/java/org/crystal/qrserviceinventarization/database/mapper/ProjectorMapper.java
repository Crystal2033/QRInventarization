/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 12.01.2024
 */

package org.crystal.qrserviceinventarization.database.mapper;

import jakarta.annotation.PostConstruct;
import org.crystal.qrserviceinventarization.database.dto.AbstractInventarizedObjectMapper;
import org.crystal.qrserviceinventarization.database.dto.ProjectorDTO;
import org.crystal.qrserviceinventarization.database.model.Projector;
import org.crystal.qrserviceinventarization.repository.CabinetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectorMapper extends AbstractInventarizedObjectMapper<Projector, ProjectorDTO> {

    @Autowired
    protected ProjectorMapper(CabinetRepository cabinetRepository) {
        super(Projector.class, ProjectorDTO.class, cabinetRepository);
    }


    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Projector.class, ProjectorDTO.class)
                .addMappings(m -> m.skip(ProjectorDTO::setCabinetId)).setPostConverter(toDtoConverter());

        mapper.createTypeMap(ProjectorDTO.class, Projector.class)
                .addMappings(m -> m.skip(Projector::setCabinet)).setPostConverter(toEntityConverter());
    }
}
