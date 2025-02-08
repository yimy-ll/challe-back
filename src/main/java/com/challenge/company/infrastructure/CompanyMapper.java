package com.challenge.company.infrastructure;

import com.challenge.company.domain.Company;
import com.challenge.company.infrastructure.persistence.entity.CompanyEntity;
import com.challenge.company.infrastructure.web.dto.CompanyDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CompanyMapper {
    Company companyEntityToCompany(CompanyEntity companyEntity);
    CompanyEntity companyToCompanyEntity(Company company);
    Company companyDTOToCompany(CompanyDto companyDTO);
    CompanyDto companyToCompanyDTO(Company company);
}
