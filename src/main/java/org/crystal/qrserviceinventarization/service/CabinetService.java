/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.service;

import org.crystal.qrserviceinventarization.repository.CabinetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CabinetService {
    private final CabinetRepository cabinetRepository;

    @Autowired
    public CabinetService(CabinetRepository cabinetRepository) {
        this.cabinetRepository = cabinetRepository;
    }
}
