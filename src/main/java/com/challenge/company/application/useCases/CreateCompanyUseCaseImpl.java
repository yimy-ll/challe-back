package com.challenge.company.application.useCases;

import com.challenge.company.domain.Company;
import com.challenge.company.domain.exception.CompanyAlreadyExistsException;
import com.challenge.company.domain.ports.in.CreateCompanyUseCase;
import com.challenge.company.domain.ports.out.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCompanyUseCaseImpl implements CreateCompanyUseCase {
    private final CompanyRepository companyRepository;

    @Override
    public Company createCompany(Company company) {
        if(companyRepository.existsCompanyByName(company.getName()))
            throw new CompanyAlreadyExistsException(company.getName());

        return companyRepository.save(company);
    }
}
