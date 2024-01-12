/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 12.01.2024
 */

package org.crystal.qrserviceinventarization.database.mapper;

import jakarta.annotation.PostConstruct;
import org.crystal.qrserviceinventarization.database.dto.AbstractInventarizedObjectMapper;
import org.crystal.qrserviceinventarization.database.dto.MonitorDTO;
import org.crystal.qrserviceinventarization.database.model.Monitor;
import org.crystal.qrserviceinventarization.repository.CabinetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MonitorMapper extends AbstractInventarizedObjectMapper<Monitor, MonitorDTO> {

    @Autowired
    protected MonitorMapper(CabinetRepository cabinetRepository) {
        super(Monitor.class, MonitorDTO.class, cabinetRepository);
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Monitor.class, MonitorDTO.class)
                .addMappings(m -> m.skip(MonitorDTO::setCabinetId)).setPostConverter(toDtoConverter());

        mapper.createTypeMap(MonitorDTO.class, Monitor.class)
                .addMappings(m -> m.skip(Monitor::setCabinet)).setPostConverter(toEntityConverter());
    }

}
