package com.challenge.company.application.useCases;

import com.challenge.company.domain.Company;
import com.challenge.company.domain.ports.in.GetCompaniesByFilterUseCase;
import com.challenge.company.domain.ports.out.CompanyRepository;
import com.challenge.company.infrastructure.web.filter.FilterCompany;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetCompaniesByFilterUseCaseImpl implements GetCompaniesByFilterUseCase {
    private final CompanyRepository companyRepository;

    @Override
    public List<Company> getCompaniesByFilter(FilterCompany filter) {
        return companyRepository.findAll(filter);
    }
}
