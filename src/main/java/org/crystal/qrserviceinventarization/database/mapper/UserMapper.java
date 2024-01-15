/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 15.01.2024
 */

package org.crystal.qrserviceinventarization.database.mapper;

import jakarta.annotation.PostConstruct;
import org.crystal.qrserviceinventarization.database.dto.UserDTO;
import org.crystal.qrserviceinventarization.database.model.User;
import org.crystal.qrserviceinventarization.exception.ResourceNotFoundException;
import org.crystal.qrserviceinventarization.repository.OrganizationRepository;
import org.crystal.qrserviceinventarization.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends AbstractMapper<User, UserDTO> {

    private final UserRepository userRepository;
    private final OrganizationRepository organizationRepository;

    protected UserMapper(UserRepository userRepository, OrganizationRepository organizationRepository) {
        super(User.class, UserDTO.class);
        this.userRepository = userRepository;
        this.organizationRepository = organizationRepository;
    }


    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(User.class, UserDTO.class)
                .addMappings(m -> m.skip(UserDTO::setOrganizationId))
                .setPostConverter(toDtoConverter());

        mapper.createTypeMap(UserDTO.class, User.class)
                .addMappings(m -> {
                    m.skip(User::setPassword);
                    m.skip(User::setOrganization);

                })
                .setPostConverter(toEntityConverter());
    }


    @Override
    protected void mapSpecificFieldsEntityToDto(User source, UserDTO destination) {
        destination.setOrganizationId(source.getOrganization().getId());
    }

    @Override
    protected void mapSpecificFieldsDtoToEntity(UserDTO source, User destination) {

        destination.setPassword(userRepository.findById(source.getId()).orElseThrow(
                        () -> new ResourceNotFoundException(STR."User with id= \{source.getId()} not found.")
                )
                .getPassword());

        destination.setOrganization(organizationRepository.findById(source.getOrganizationId()).orElseThrow(
                () -> new ResourceNotFoundException(STR."Organization with id=\{source.getOrganizationId()} not found.")
        ));
    }
}
