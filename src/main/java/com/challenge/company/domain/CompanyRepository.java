package com.challenge.company.domain;

import com.challenge.company.infrastructure.web.filter.FilterCompany;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository {
    Company save(Company company);

    List<Company> findAll(FilterCompany filter);
}