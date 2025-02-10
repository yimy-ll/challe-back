package com.challenge.company.domain.ports.in;

import com.challenge.company.domain.Company;

public interface CreateCompanyUseCase {
    Company createCompany(Company company);
}
