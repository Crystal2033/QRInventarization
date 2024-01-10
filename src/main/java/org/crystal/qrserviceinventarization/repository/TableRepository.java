package org.crystal.qrserviceinventarization.repository;

import org.crystal.qrserviceinventarization.database.model.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TableRepository extends JpaRepository<Table, Long> {
    List<Table> findTablesByCabinetId(Long cabinetId);

}
