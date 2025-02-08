package com.challenge.company.infrastructure.persistence;

import com.challenge.company.domain.Company;
import com.challenge.company.domain.CompanyRepository;
import com.challenge.company.infrastructure.CompanyMapper;
import com.challenge.company.infrastructure.persistence.entity.CompanyEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RepositoryAdapter implements CompanyRepository {
    private final PostgreSQLCompanyRepository postgreSQLCompanyRepository;
    private final CompanyMapper companyMapper;

    @Override
    public Company save(Company company) {
        CompanyEntity updatedCompanyEntity = companyMapper.companyToCompanyEntity(company);
        updatedCompanyEntity = postgreSQLCompanyRepository.save(updatedCompanyEntity);
        return companyMapper.companyEntityToCompany(updatedCompanyEntity);
    }

    @Override
    public Optional<Company> findById(String id) {
        Optional<CompanyEntity> companyEntity = postgreSQLCompanyRepository.findById(id);
        return companyEntity.map(companyMapper::companyEntityToCompany);
    }

    @Override
    public void deleteById(String id) {
        postgreSQLCompanyRepository.deleteById(id);
    }

    @Override
    public Company update(Company company) {
        return this.save(company);
    }

    @Override
    public List<Company> findAll() {
        return postgreSQLCompanyRepository.findAll().stream()
                .map(companyMapper::companyEntityToCompany)
                .toList();
    }
}