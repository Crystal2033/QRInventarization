/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 12.01.2024
 */

package org.crystal.qrserviceinventarization.database.mapper;

import jakarta.annotation.PostConstruct;
import org.crystal.qrserviceinventarization.database.dto.AbstractInventarizedObjectMapper;
import org.crystal.qrserviceinventarization.database.dto.KeyboardDTO;
import org.crystal.qrserviceinventarization.database.model.Keyboard;
import org.crystal.qrserviceinventarization.repository.CabinetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KeyboardMapper extends AbstractInventarizedObjectMapper<Keyboard, KeyboardDTO> {


    @Autowired
    protected KeyboardMapper(CabinetRepository cabinetRepository) {
        super(Keyboard.class, KeyboardDTO.class, cabinetRepository);
    }


    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Keyboard.class, KeyboardDTO.class)
                .addMappings(m -> m.skip(KeyboardDTO::setCabinetId)).setPostConverter(toDtoConverter());

        mapper.createTypeMap(KeyboardDTO.class, Keyboard.class)
                .addMappings(m -> m.skip(Keyboard::setCabinet)).setPostConverter(toEntityConverter());
    }

}
