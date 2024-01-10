/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.service;

import org.crystal.qrserviceinventarization.database.model.Projector;
import org.crystal.qrserviceinventarization.repository.ProjectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectorService {
    private final ProjectorRepository projectorRepository;

    @Autowired
    public ProjectorService(ProjectorRepository projectorRepository) {
        this.projectorRepository = projectorRepository;
    }

    public List<Projector> getProjectorsByCabinetId(Long cabinetId){
        return projectorRepository.findProjectorsByCabinetId(cabinetId);
    }
}
