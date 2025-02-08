package com.challenge.transfer.domain;

import java.util.List;

public interface TransferService {
    Transfer update(Transfer user);

    List<Transfer> findAll();

    Transfer findById(String id);

    void delete(Long id);
}
