package org.crystal.qrserviceinventarization.repository;

import org.crystal.qrserviceinventarization.database.model.Keyboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyboardRepository extends JpaRepository<Keyboard, Long> {
}
