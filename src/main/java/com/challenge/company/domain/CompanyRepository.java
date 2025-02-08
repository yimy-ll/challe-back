package com.challenge.company.domain;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository {
    Company save(Company company);

    Company update(Company company);

    List<Company> findAll();

    Optional<Company> findById(String id);

    void deleteById(String id);
}