package com.challenge.company.infrastructure;

import com.challenge.company.domain.Company;
import com.challenge.company.infrastructure.persistence.entity.CompanyEntity;
import com.challenge.company.infrastructure.web.dto.CompanyDto;
import com.challenge.transfer.domain.Transfer;
import com.challenge.transfer.infrastructure.TransferMapper;
import com.challenge.transfer.infrastructure.persistence.entity.TransferEntity;
import com.challenge.transfer.infrastructure.web.TransferDto;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CompanyMapper {
    @Mapping(target = "transfers", ignore = true)
    Company companyEntityToCompany(CompanyEntity companyEntity);

    @Mapping(target = "transfers", ignore = true)
    CompanyEntity companyToCompanyEntity(Company company);

    @Mapping(target = "transfers", ignore = true)
    Company companyDtoToCompany(CompanyDto companyDTO);

    @Mapping(target = "transfers", ignore = true)
    CompanyDto companyToCompanyDto(Company company);
}
