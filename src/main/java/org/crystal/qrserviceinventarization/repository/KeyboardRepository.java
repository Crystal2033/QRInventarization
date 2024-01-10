package org.crystal.qrserviceinventarization.repository;

import org.crystal.qrserviceinventarization.database.model.Keyboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeyboardRepository extends JpaRepository<Keyboard, Long> {
    List<Keyboard> findKeyboardsByCabinetId(Long cabinetId);
}
