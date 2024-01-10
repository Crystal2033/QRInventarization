package org.crystal.qrserviceinventarization.repository;

import org.crystal.qrserviceinventarization.database.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {
    List<Branch> getBranchesByOrganizationId(Long orgId);
}
