package com.challenge.company.application;

import com.challenge.company.domain.Company;
import com.challenge.company.domain.CompanyRepository;
import com.challenge.company.domain.CompanyService;
import com.challenge.company.infrastructure.web.filter.FilterCompany;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public List<Company> findAll(FilterCompany filter) {
        return companyRepository.findAll(filter);
    }
}
