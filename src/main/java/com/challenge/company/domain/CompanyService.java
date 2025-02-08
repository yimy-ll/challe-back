package com.challenge.company.domain;

import com.challenge.company.application.CompanyServiceImpl;

import java.util.List;

public interface CompanyService {
    Company save(Company company);

    Company update(Company company);

    List<Company> findAll();

    Company findById(String id);

    void deleteById(String id);
}