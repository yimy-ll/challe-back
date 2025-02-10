package com.challenge.transfer.domain;

import java.util.List;

public interface TransferService {
    Transfer create(Transfer transfer);

    List<Transfer> findAll();
}