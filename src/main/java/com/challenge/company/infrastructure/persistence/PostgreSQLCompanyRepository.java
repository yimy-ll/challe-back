package com.challenge.company.infrastructure.persistence;

import com.challenge.company.infrastructure.persistence.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgreSQLCompanyRepository extends JpaRepository<CompanyEntity, String>, JpaSpecificationExecutor<CompanyEntity> {
}