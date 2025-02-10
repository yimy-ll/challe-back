package com.challenge.company;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.challenge.company.application.useCases.GetCompaniesByFilterUseCaseImpl;
import com.challenge.company.domain.Company;
import com.challenge.company.domain.ports.out.CompanyRepository;
import com.challenge.company.infrastructure.web.filter.FilterCompany;
import com.challenge.transfer.domain.Transfer;
import com.challenge.transfer.domain.TransferType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
class GetCompaniesByFilterUseCaseTest {

    @Mock
    private CompanyRepository companyRepository;

    @InjectMocks
    private GetCompaniesByFilterUseCaseImpl getCompaniesByFilterUseCase;

    private static final LocalDateTime NOW = LocalDateTime.of(2025, 2, 9, 10, 0);
    private static final LocalDateTime LAST_MONTH = NOW.toLocalDate().withDayOfMonth(1).atStartOfDay();

    @Test
    @DisplayName("Debe retornar empresas que se adhirieron en el último mes")
    void shouldReturnCompaniesJoinedLastMonth() {
        FilterCompany filter = FilterCompany.builder().companiesJoinedLastMonth(true).build();

        Company company1 = Company.builder()
                .id("550e8400-e29b-41d4-a716-446655440000")
                .name("Tech Solutions")
                .dateOfAccession(NOW)
                .build();
        Company company2 = Company.builder().
                id("550e8400-e29b-41d4-a716-446655440001")
                .name("Global Corp")
                .dateOfAccession(NOW)
                .build();

        List<Company> expectedCompanies = List.of(company1, company2);
        when(companyRepository.findAll(filter)).thenReturn(expectedCompanies);

        List<Company> result = getCompaniesByFilterUseCase.getCompaniesByFilter(filter);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(company1));
        assertTrue(result.contains(company2));

        verify(companyRepository, times(1)).findAll(filter);
    }

    @Test
    @DisplayName("Debe retornar empresas que realizaron transferencias en el último mes")
    void shouldReturnCompaniesWithTransfersLastMonth() {
        FilterCompany filter = FilterCompany.builder().companiesWithTransfersLastMonth(true).build();

        Transfer transfer1 = Transfer.builder()
                .id("550e8400-e29b-41d4-a716-446655440000")
                .amount(1000.0)
                .transferType(TransferType.CUENTA_DEBITO)
                .dateTransfer(NOW.minusDays(5))
                .build();

        Transfer transfer2 = Transfer.builder()
                .id("550e8400-e29b-41d4-a716-446655440001")
                .amount(2000.0)
                .transferType(TransferType.CUENTA_DEBITO)
                .dateTransfer(NOW.minusDays(2))
                .build();

        Company company1 = Company.builder().
                id("550e8400-e29b-41d4-a716-446655440000")
                .name("Tech Solutions")
                .dateOfAccession(NOW.minusMonths(5))
                .transfers(Set.of(transfer1))
                .build();

        Company company2 = Company.builder()
                .id("550e8400-e29b-41d4-a716-446655440001")
                .name("Global Corp")
                .dateOfAccession(NOW.minusMonths(3))
                .transfers(Set.of(transfer2))
                .build();

        List<Company> expectedCompanies = List.of(company1, company2);

        when(companyRepository.findAll(filter)).thenReturn(expectedCompanies);

        List<Company> result = getCompaniesByFilterUseCase.getCompaniesByFilter(filter);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(company1));
        assertTrue(result.contains(company2));

        for (Company company : result) {
            assertFalse(company.getTransfers().isEmpty(), "La empresa debería tener transferencias");
            assertTrue(company.getTransfers().stream()
                            .anyMatch(t -> t.getDateTransfer().isAfter(LAST_MONTH)),
                    "La empresa debe haber realizado una transferencia en el último mes");
        }

        verify(companyRepository, times(1)).findAll(filter);
    }
}
