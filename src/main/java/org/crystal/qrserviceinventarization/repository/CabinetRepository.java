package org.crystal.qrserviceinventarization.repository;

import org.crystal.qrserviceinventarization.database.model.Cabinet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabinetRepository extends JpaRepository<Cabinet, Long> {
}
