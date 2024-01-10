package org.crystal.qrserviceinventarization.repository;

import org.crystal.qrserviceinventarization.database.model.Desk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeskRepository extends JpaRepository<Desk, Long> {
    List<Desk> findDesksByCabinetId(Long cabinetId);

}
