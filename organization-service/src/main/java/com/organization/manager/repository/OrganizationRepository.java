package com.organization.manager.repository;


import com.organization.manager.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization,Long> {

    Organization findByOrgCode(String orgCode);
}
