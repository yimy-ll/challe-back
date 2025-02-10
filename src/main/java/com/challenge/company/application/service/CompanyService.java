package com.challenge.company.application.service;

import com.challenge.company.domain.Company;
import com.challenge.company.domain.ports.in.CreateCompanyUseCase;
import com.challenge.company.domain.ports.in.GetCompaniesByFilterUseCase;
import com.challenge.company.infrastructure.web.filter.FilterCompany;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService implements CreateCompanyUseCase, GetCompaniesByFilterUseCase {
    private final CreateCompanyUseCase createCompanyUseCase;
    private final GetCompaniesByFilterUseCase getCompaniesByFilterUseCase;

    @Override
    public Company createCompany(Company company) {
        return createCompanyUseCase.createCompany(company);
    }

    @Override
    public List<Company> getCompaniesByFilter(FilterCompany filter) {
        return getCompaniesByFilterUseCase.getCompaniesByFilter(filter);
    }
}