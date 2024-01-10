/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.service;

import org.crystal.qrserviceinventarization.database.model.Chair;
import org.crystal.qrserviceinventarization.repository.ChairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChairService {
    private final ChairRepository chairRepository;

    @Autowired
    public ChairService(ChairRepository chairRepository) {
        this.chairRepository = chairRepository;
    }

    public List<Chair> getChairsByCabinetId(Long cabinetId){
        return chairRepository.findChairsByCabinetId(cabinetId);
    }
}
