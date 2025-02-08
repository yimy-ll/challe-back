package com.challenge.transfer.infrastructure.persistence;

import com.challenge.transfer.domain.Transfer;
import com.challenge.transfer.domain.TransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RepositoryAdapter implements TransferRepository {
    private final PostgreSQLTransferRepository postgreSQLTransferRepository;

    @Override
    public Transfer save(Transfer transfer) {
        return null;
    }

    @Override
    public Optional<Transfer> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Transfer update(Transfer transfer) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }
}
