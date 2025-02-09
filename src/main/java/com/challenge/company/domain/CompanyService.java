package com.challenge.company.domain;

import com.challenge.company.application.CompanyServiceImpl;
import com.challenge.company.infrastructure.web.filter.FilterCompany;

import java.util.List;

public interface CompanyService {
    Company save(Company company);

    Company update(Company company);

    List<Company> findAll(FilterCompany filter);

    Company findById(String id);

    void deleteById(String id);
}