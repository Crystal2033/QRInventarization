/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.service;

import org.crystal.qrserviceinventarization.database.dto.DeskDTO;
import org.crystal.qrserviceinventarization.database.model.Desk;
import org.crystal.qrserviceinventarization.repository.DeskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeskService {
    private final DeskRepository deskRepository;

    @Autowired
    public DeskService(DeskRepository deskRepository) {
        this.deskRepository = deskRepository;
    }

//    public List<DeskDTO> getDesksByCabinetId(Long cabinetId) {
//
//    }
}
