package com.challenge.transfer;

import com.challenge.company.application.service.CompanyService;
import com.challenge.company.domain.Company;
import com.challenge.company.domain.exception.CompanyNotFoundException;
import com.challenge.transfer.application.useCases.CreateTransferUseCaseImpl;
import com.challenge.transfer.domain.Transfer;
import com.challenge.transfer.domain.TransferType;
import com.challenge.transfer.domain.ports.out.TransferRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CreateTransferUseCaseTest {

    @Mock
    private TransferRepository transferRepository;

    @Mock
    private CompanyService companyService;

    @InjectMocks
    private CreateTransferUseCaseImpl createTransferUseCase;

    private Transfer transfer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        transfer = Transfer.builder()
                .id("12345")
                .company(Company.builder().id("67890").build())
                .amount(100.0)
                .transferType(TransferType.CUENTA_DEBITO)
                .build();
    }

    @Test
    void testCreateTransferSuccess() {
        when(companyService.existCompanyById(transfer.getCompanyId())).thenReturn(true);
        when(transferRepository.save(transfer)).thenReturn(transfer);

        Transfer createdTransfer = createTransferUseCase.createTransfer(transfer);

        assertNotNull(createdTransfer);
        assertEquals(transfer.getId(), createdTransfer.getId());
        assertEquals(transfer.getCompanyId(), createdTransfer.getCompanyId());

        verify(transferRepository, times(1)).save(transfer);
    }

    @Test
    void testCreateTransferCompanyNotFound() {
        when(companyService.existCompanyById(transfer.getCompanyId())).thenReturn(false);

        assertThrows(CompanyNotFoundException.class, () -> createTransferUseCase.createTransfer(transfer));

        verify(transferRepository, never()).save(any(Transfer.class));
    }
}