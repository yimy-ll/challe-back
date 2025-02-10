package com.challenge.transfer.application.useCases;

import com.challenge.transfer.domain.Transfer;
import com.challenge.transfer.domain.ports.in.CreateTransferUseCase;
import com.challenge.transfer.domain.ports.out.TransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTransferUseCaseImpl implements CreateTransferUseCase {
    private final TransferRepository transferRepository;

    @Override
    public Transfer createTransfer(Transfer transfer) {
        return transferRepository.save(transfer);
    }
}
