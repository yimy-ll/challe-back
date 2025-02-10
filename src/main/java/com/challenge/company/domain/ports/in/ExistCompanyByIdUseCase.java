package com.challenge.company.domain.ports.in;

import com.challenge.company.domain.Company;

public interface ExistCompanyByIdUseCase {
    Boolean existCompanyById(String companyId);
}
