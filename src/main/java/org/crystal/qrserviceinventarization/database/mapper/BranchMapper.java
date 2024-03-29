/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 11.01.2024
 */

package org.crystal.qrserviceinventarization.database.mapper;

import jakarta.annotation.PostConstruct;
import org.crystal.qrserviceinventarization.database.dto.BranchDTO;
import org.crystal.qrserviceinventarization.database.model.Branch;
import org.crystal.qrserviceinventarization.exception.ResourceNotFoundException;
import org.crystal.qrserviceinventarization.repository.CityRepository;
import org.crystal.qrserviceinventarization.repository.OrganizationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class BranchMapper extends AbstractMapper<Branch, BranchDTO> {

    //private final ModelMapper mapper;
    private final CityRepository cityRepository;
    private final OrganizationRepository organizationRepository;

    @Autowired
    BranchMapper(CityRepository cityRepository, OrganizationRepository organizationRepository) {
        super(Branch.class, BranchDTO.class);
        this.cityRepository = cityRepository;
        this.organizationRepository = organizationRepository;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Branch.class, BranchDTO.class)
                .addMappings(
                        m -> {
                            m.skip(BranchDTO::setCityId);
                            m.skip(BranchDTO::setCityName);
                            m.skip(BranchDTO::setOrganizationId);
                        }).setPostConverter(toDtoConverter());

        mapper.createTypeMap(BranchDTO.class, Branch.class)
                .addMappings(
                        m -> {
                            m.skip(Branch::setCity);
                            m.skip(Branch::setOrganization);
                        }).setPostConverter(toEntityConverter());
    }

    @Override
    protected void mapSpecificFieldsEntityToDto(Branch source, BranchDTO destination) {
        destination.setCityId(source.getCity().getId());
        destination.setCityName(source.getCity().getName());
        destination.setOrganizationId(source.getOrganization().getId());
    }

    @Override
    protected void mapSpecificFieldsDtoToEntity(BranchDTO source, Branch destination) {
        destination.setCity(
                cityRepository.findById(source.getCityId())
                        .orElseThrow(() -> new ResourceNotFoundException(STR."City with id = \{source.getCityId()} not found")));

        destination.setOrganization(organizationRepository.findById(source.getOrganizationId()).orElseThrow(
                () -> new ResourceNotFoundException(STR."Organization with id = \{source.getOrganizationId()} not found")
        ));
    }
}
