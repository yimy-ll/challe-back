package com.challenge.company;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.challenge.company.application.useCases.CreateCompanyUseCaseImpl;
import com.challenge.company.domain.Company;
import com.challenge.company.domain.exception.CompanyAlreadyExistsException;
import com.challenge.company.domain.ports.out.CompanyRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
class CreateCompanyUseCaseImplTest {
    private final LocalDateTime DATA_TIME_TEST = LocalDateTime.of(2021, 1, 1, 0, 0);

    @Mock
    private CompanyRepository companyRepository;

    @InjectMocks
    private CreateCompanyUseCaseImpl createCompanyUseCase;

    @Test
    @DisplayName("Debe crear una empresa correctamente")
    void createCompany_Success() {
        Company company = Company.builder()
                .dateOfAccession(DATA_TIME_TEST)
                .name("Tech Solutions")
                .build();

        when(companyRepository.existsCompanyByName(company.getName())).thenReturn(false);
        when(companyRepository.save(any(Company.class))).thenReturn(company);

        Company result = createCompanyUseCase.createCompany(company);

        assertNotNull(result, "La empresa no debería ser nula");
        assertEquals(company.getName(), result.getName(), "El nombre de la empresa no coincide");
        assertEquals(company.getDateOfAccession(), result.getDateOfAccession(), "La fecha de adhesión no coincide");

        verify(companyRepository, times(1)).existsCompanyByName(company.getName());
        verify(companyRepository, times(1)).save(company);

        verifyNoMoreInteractions(companyRepository);
    }

    @Test
    @DisplayName("Debe lanzar una excepción si la empresa ya existe")
    void createCompanyThrowsExceptionWhenDuplicate() {
        Company company = Company.builder()
                .name("Tech Solutions")
                .dateOfAccession(DATA_TIME_TEST)
                .build();
        when(companyRepository.existsCompanyByName(company.getName())).thenReturn(true);

        CompanyAlreadyExistsException exception = assertThrows(CompanyAlreadyExistsException.class, () -> {
            createCompanyUseCase.createCompany(company);
        });

        assertEquals(CompanyAlreadyExistsException.class.getSimpleName(), exception.getClass().getSimpleName());
        verify(companyRepository, times(1)).existsCompanyByName(company.getName());
        verify(companyRepository, never()).save(any(Company.class));
    }
}

