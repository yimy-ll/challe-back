package com.challenge.company.domain.ports.in;

import com.challenge.company.domain.Company;
import com.challenge.company.infrastructure.web.filter.FilterCompany;

import java.util.List;

public interface GetCompaniesByFilterUseCase {
    List<Company> getCompaniesByFilter(FilterCompany filter);
}
