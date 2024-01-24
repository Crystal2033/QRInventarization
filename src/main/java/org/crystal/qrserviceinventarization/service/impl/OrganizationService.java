/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.service.impl;

import org.crystal.qrserviceinventarization.database.dto.OrganizationDTO;
import org.crystal.qrserviceinventarization.database.mapper.OrganizationMapper;
import org.crystal.qrserviceinventarization.exception.ResourceNotFoundException;
import org.crystal.qrserviceinventarization.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {

    private final OrganizationMapper organizationMapper;
    private final OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationService(OrganizationMapper organizationMapper, OrganizationRepository organizationRepository) {
        this.organizationMapper = organizationMapper;
        this.organizationRepository = organizationRepository;
    }

    public List<OrganizationDTO> getAllOrganizations() {
        var organizations = organizationRepository.findAll();
        if (organizations.isEmpty()) {
            throw new ResourceNotFoundException("There are no organizations yet");
        }
        return organizations
                .stream()
                .map(organizationMapper::toDto)
                .toList();
    }

    public OrganizationDTO getOrganizationById(Long orgId) {
        var organization = organizationRepository.findById(orgId);

        return organizationMapper.toDto(
                organizationRepository.save(organization.orElseThrow(()
                        -> new ResourceNotFoundException(STR."Organization with id=\{orgId} can not be found"))));
    }

    public OrganizationDTO saveOrganization(OrganizationDTO organizationDTO) {
        var savedOrganization = organizationRepository.save(organizationMapper.toEntity(organizationDTO));
        return organizationMapper.toDto(savedOrganization);
    }

    public void deleteOrganizationById(Long orgId) {
        organizationRepository.deleteById(orgId);
    }
}
