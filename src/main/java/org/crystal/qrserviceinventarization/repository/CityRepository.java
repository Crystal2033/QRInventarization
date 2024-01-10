package org.crystal.qrserviceinventarization.repository;

import org.crystal.qrserviceinventarization.database.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
