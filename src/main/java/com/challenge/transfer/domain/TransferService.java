package com.challenge.transfer.domain;

import java.util.List;

public interface TransferService {
    Transfer update(Transfer transfer);

    List<Transfer> findAll();

    Transfer findById(String id);

    void delete(String id);
}