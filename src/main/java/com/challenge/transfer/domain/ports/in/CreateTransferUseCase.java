package com.challenge.transfer.domain.ports.in;

import com.challenge.transfer.domain.Transfer;

public interface CreateTransferUseCase {
    Transfer createTransfer(Transfer transfer);
}
