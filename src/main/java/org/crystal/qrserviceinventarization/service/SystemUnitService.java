/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.service;

import org.crystal.qrserviceinventarization.repository.SystemUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemUnitService {
    private final SystemUnitRepository systemUnitRepository;

    @Autowired
    public SystemUnitService(SystemUnitRepository systemUnitRepository) {
        this.systemUnitRepository = systemUnitRepository;
    }
}
