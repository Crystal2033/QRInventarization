/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.service;

import org.crystal.qrserviceinventarization.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingService {
    private final BuildingRepository buildingRepository;
    
    @Autowired
    public BuildingService(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }
}
