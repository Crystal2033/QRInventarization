package org.crystal.qrserviceinventarization.repository;

import org.crystal.qrserviceinventarization.database.model.Chair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChairRepository extends JpaRepository<Chair, Long> {
    List<Chair> findChairsByCabinetId(Long cabinetId);
}
