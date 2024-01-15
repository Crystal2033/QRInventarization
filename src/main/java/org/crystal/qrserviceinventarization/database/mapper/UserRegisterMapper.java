/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 15.01.2024
 */

package org.crystal.qrserviceinventarization.database.mapper;

import jakarta.annotation.PostConstruct;
import org.crystal.qrserviceinventarization.database.dto.UserRegisterDTO;
import org.crystal.qrserviceinventarization.database.model.User;
import org.crystal.qrserviceinventarization.exception.ResourceNotFoundException;
import org.crystal.qrserviceinventarization.repository.OrganizationRepository;
import org.springframework.stereotype.Component;

@Component
public class UserRegisterMapper extends AbstractMapper<User, UserRegisterDTO> {

    private final OrganizationRepository organizationRepository;

    protected UserRegisterMapper(OrganizationRepository organizationRepository) {
        super(User.class, UserRegisterDTO.class);
        this.organizationRepository = organizationRepository;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(User.class, UserRegisterDTO.class)
                .addMappings(m -> m.skip(UserRegisterDTO::setOrganizationId))
                .setPostConverter(toDtoConverter());

        mapper.createTypeMap(UserRegisterDTO.class, User.class)
                .addMappings(m -> m.skip(User::setOrganization))
                .setPostConverter(toEntityConverter());
    }

    @Override
    protected void mapSpecificFieldsEntityToDto(User source, UserRegisterDTO destination) {
        destination.setOrganizationId(source.getOrganization().getId());
    }

    @Override
    protected void mapSpecificFieldsDtoToEntity(UserRegisterDTO source, User destination) {
        destination.setOrganization(
                organizationRepository.findById(source.getOrganizationId()).orElseThrow(
                        () -> new ResourceNotFoundException(STR."Organization with id=\{source.getOrganizationId()} not found.")
                )
        );
    }
}


