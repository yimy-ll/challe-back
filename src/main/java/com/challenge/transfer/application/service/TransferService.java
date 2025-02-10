package com.challenge.transfer.application.service;

import com.challenge.transfer.domain.Transfer;
import com.challenge.transfer.domain.ports.in.CreateTransferUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferService implements CreateTransferUseCase {

    private final CreateTransferUseCase createTransferUseCase;

    @Override
    public Transfer createTransfer(Transfer transfer) {
        return createTransferUseCase.createTransfer(transfer);
    }
}