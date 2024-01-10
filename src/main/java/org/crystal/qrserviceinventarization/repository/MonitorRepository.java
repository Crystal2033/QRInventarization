package org.crystal.qrserviceinventarization.repository;

import org.crystal.qrserviceinventarization.database.model.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitorRepository extends JpaRepository<Monitor, Long> {
}
