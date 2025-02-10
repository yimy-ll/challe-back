package com.challenge.transfer.domain;

import java.util.List;

public interface TransferRepository {
    Transfer save(Transfer transfer);
    List<Transfer> findAll();
}
