package com.challenge.company.application.useCases;

import com.challenge.company.domain.ports.in.ExistCompanyByIdUseCase;
import com.challenge.company.domain.ports.out.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExistCompanyByIdUseCaseImpl implements ExistCompanyByIdUseCase {
    private final CompanyRepository companyRepository;

    @Override
    public Boolean existCompanyById(String companyId) {
        return companyRepository.existCompanyById(companyId);
    }
}