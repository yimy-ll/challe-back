package com.challenge.transfer.domain.ports.out;

import com.challenge.transfer.domain.Transfer;

import java.util.List;

public interface TransferRepository {
    Transfer save(Transfer transfer);
    List<Transfer> findAll();
}
