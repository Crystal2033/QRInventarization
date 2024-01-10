package org.crystal.qrserviceinventarization.repository;

import org.crystal.qrserviceinventarization.database.model.Projector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectorRepository extends JpaRepository<Projector, Long> {
    List<Projector> findProjectorsByCabinetId(Long cabinetId);
}
