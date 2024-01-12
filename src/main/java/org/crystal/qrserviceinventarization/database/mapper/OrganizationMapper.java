/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 11.01.2024
 */

package org.crystal.qrserviceinventarization.database.mapper;

import org.crystal.qrserviceinventarization.database.dto.OrganizationDTO;
import org.crystal.qrserviceinventarization.database.model.Organization;
import org.springframework.stereotype.Component;

@Component
public class OrganizationMapper extends AbstractMapper<Organization, OrganizationDTO> {

    public OrganizationMapper() {
        super(Organization.class, OrganizationDTO.class);
    }

}
