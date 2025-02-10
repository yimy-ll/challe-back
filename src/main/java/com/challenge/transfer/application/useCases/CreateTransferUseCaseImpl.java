package com.challenge.transfer.application.useCases;

import com.challenge.company.application.service.CompanyService;
import com.challenge.company.domain.exception.CompanyNotFoundException;
import com.challenge.transfer.domain.Transfer;
import com.challenge.transfer.domain.ports.in.CreateTransferUseCase;
import com.challenge.transfer.domain.ports.out.TransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTransferUseCaseImpl implements CreateTransferUseCase {
    private final TransferRepository transferRepository;
    private final CompanyService companyService;

    @Override
    public Transfer createTransfer(Transfer transfer) {
        if (!companyService.existCompanyById(transfer.getCompanyId()))
            throw new CompanyNotFoundException(transfer.getCompanyId());

        return transferRepository.save(transfer);
    }
}
