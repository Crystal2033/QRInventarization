/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 10.01.2024
 */

package org.crystal.qrserviceinventarization.service.impl;

import org.crystal.qrserviceinventarization.database.dto.KeyboardDTO;
import org.crystal.qrserviceinventarization.database.mapper.KeyboardMapper;
import org.crystal.qrserviceinventarization.exception.ResourceNotFoundException;
import org.crystal.qrserviceinventarization.repository.KeyboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeyboardService {
    private final KeyboardRepository keyboardRepository;

    private final KeyboardMapper keyboardMapper;

    @Autowired
    public KeyboardService(KeyboardRepository keyboardRepository, KeyboardMapper keyboardMapper) {
        this.keyboardRepository = keyboardRepository;
        this.keyboardMapper = keyboardMapper;
    }

    public List<KeyboardDTO> getKeyboardsByCabinetId(Long cabinetId) {
        var keyboards = keyboardRepository.findKeyboardsByCabinetId(cabinetId);
        if (keyboards.isEmpty()) {
            throw new ResourceNotFoundException(STR."Keyboards with cabinet id = \{cabinetId} not found");
        }
        return keyboards
                .stream()
                .map(keyboardMapper::toDto)
                .toList();
    }

    public KeyboardDTO saveKeyboard(KeyboardDTO keyboardDTO) {
        var savedKeyboard = keyboardRepository.save(keyboardMapper.toEntity(keyboardDTO));
        return keyboardMapper.toDto(savedKeyboard);
    }

    public KeyboardDTO getKeyboardById(Long keyboardId) {
        var keyboard = keyboardRepository.findById(keyboardId).orElseThrow(
                () -> new ResourceNotFoundException(STR."Keyboard with id= \{keyboardId} not found")
        );
        return keyboardMapper.toDto(keyboard);
    }

    public void deleteKeyboardById(Long keyboardId) {
        var keyboard = keyboardRepository.findById(keyboardId).orElseThrow(
                () -> new ResourceNotFoundException(STR."Keyboard with id= \{keyboardId} not found")
        );

        keyboardRepository.delete(keyboard);
    }
}
