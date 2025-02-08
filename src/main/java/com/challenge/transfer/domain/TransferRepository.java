package com.challenge.transfer.domain;

import java.util.Optional;

public interface TransferRepository {
    Transfer save(Transfer transfer);
    Optional<Transfer> findById(String id);
    Transfer update(Transfer transfer);
    void deleteById(String id);
}
