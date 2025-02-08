package com.challenge.transfer.infrastructure.persistence;

import com.challenge.transfer.infrastructure.persistence.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgreSQLTransferRepository extends JpaRepository<Transfer, String>, JpaSpecificationExecutor<Transfer> {
}