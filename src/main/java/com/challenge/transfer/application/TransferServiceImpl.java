package com.challenge.transfer.application;

import com.challenge.transfer.domain.Transfer;
import com.challenge.transfer.domain.TransferRepository;
import com.challenge.transfer.domain.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {

    private final TransferRepository transferRepository;

    @Override
    public Transfer create(Transfer transfer) {
        return transferRepository.save(transfer);
    }

    @Override
    public List<Transfer> findAll() {
        return transferRepository.findAll();
    }
}