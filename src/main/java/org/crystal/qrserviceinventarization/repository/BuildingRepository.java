package org.crystal.qrserviceinventarization.repository;

import org.crystal.qrserviceinventarization.database.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
    List<Building> getBuildingsByBranchId(Long branchId);
}
