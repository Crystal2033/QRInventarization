/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.service;

import org.crystal.qrserviceinventarization.database.model.SystemUnit;
import org.crystal.qrserviceinventarization.repository.SystemUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemUnitService {
    private final SystemUnitRepository systemUnitRepository;

    @Autowired
    public SystemUnitService(SystemUnitRepository systemUnitRepository) {
        this.systemUnitRepository = systemUnitRepository;
    }

    public List<SystemUnit> getSystemUnitsByCabinetId(Long cabinetId){
        return systemUnitRepository.findSystemUnitsByCabinetId(cabinetId);
    }
}
