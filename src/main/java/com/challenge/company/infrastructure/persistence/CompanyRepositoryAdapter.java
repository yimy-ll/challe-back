package com.challenge.company.infrastructure.persistence;

import com.challenge.company.domain.Company;
import com.challenge.company.domain.ports.out.CompanyRepository;
import com.challenge.company.infrastructure.CompanyMapper;
import com.challenge.company.infrastructure.persistence.entity.CompanyEntity;
import com.challenge.company.infrastructure.persistence.specification.CompanySpecifications;
import com.challenge.company.infrastructure.web.filter.FilterCompany;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CompanyRepositoryAdapter implements CompanyRepository {
    private final PostgreSQLCompanyRepository postgreSQLCompanyRepository;
    private final CompanyMapper companyMapper;

    @Override
    @Transactional
    public Company save(Company company) {
        CompanyEntity updatedCompanyEntity = companyMapper.companyToCompanyEntity(company);
        updatedCompanyEntity = postgreSQLCompanyRepository.save(updatedCompanyEntity);
        return companyMapper.companyEntityToCompany(updatedCompanyEntity);
    }

    @Override
    public List<Company> findAll(FilterCompany filter) {
        return postgreSQLCompanyRepository.findAll(CompanySpecifications.findStockByFilter(filter)).stream()
                .map(companyMapper::companyEntityToCompany)
                .toList();
    }

    @Override
    public Boolean existsCompanyByName(String name) {
        return postgreSQLCompanyRepository.existsCompanyEntityByName(name);
    }
}