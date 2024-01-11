/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 11.01.2024
 */

package org.crystal.qrserviceinventarization.database.mapper;

import jakarta.annotation.PostConstruct;
import org.crystal.qrserviceinventarization.database.dto.OrganizationDTO;
import org.crystal.qrserviceinventarization.database.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrganizationMapper extends AbstractMapper<Organization, OrganizationDTO> {
    private final EntityDtoMapper mapper;

    @Autowired
    public OrganizationMapper(EntityDtoMapper mapper) {
        super(Organization.class, OrganizationDTO.class);
        this.mapper = mapper;
    }

}
