package org.crystal.qrserviceinventarization.repository;

import org.crystal.qrserviceinventarization.database.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
