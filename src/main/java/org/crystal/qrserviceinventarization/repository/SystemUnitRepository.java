package org.crystal.qrserviceinventarization.repository;

import org.crystal.qrserviceinventarization.database.model.SystemUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemUnitRepository extends JpaRepository<SystemUnit, Long> {
}
