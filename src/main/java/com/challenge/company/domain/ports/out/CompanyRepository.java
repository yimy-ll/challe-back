package com.challenge.company.domain.ports.out;

import com.challenge.company.domain.Company;
import com.challenge.company.infrastructure.web.filter.FilterCompany;

import java.util.List;

public interface CompanyRepository {
    Company save(Company company);

    List<Company> findAll(FilterCompany filter);

    Boolean existsCompanyByName(String name);
}