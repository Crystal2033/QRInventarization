/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.service;

import org.crystal.qrserviceinventarization.database.model.Keyboard;
import org.crystal.qrserviceinventarization.repository.KeyboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeyboardService {
    private final KeyboardRepository keyboardRepository;

    @Autowired
    public KeyboardService(KeyboardRepository keyboardRepository) {
        this.keyboardRepository = keyboardRepository;
    }

    public List<Keyboard> getKeyboardsByCabinetId(Long cabinetId){
        return keyboardRepository.findKeyboardsByCabinetId(cabinetId);
    }
}
