package com.challenge.company;

import static org.junit.jupiter.api.Assertions.*;

import com.challenge.company.domain.Company;
import com.challenge.company.infrastructure.CompanyMapper;
import com.challenge.company.infrastructure.persistence.entity.CompanyEntity;
import com.challenge.company.infrastructure.web.dto.CompanyDto;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.Set;

class CompanyMapperTest {
    private final CompanyMapper companyMapper = Mappers.getMapper(CompanyMapper.class);
    private final LocalDateTime DATA_TIME_TEST = LocalDateTime.of(2021, 1, 1, 0, 0);

    @Test
    void testShouldMapCompanyEntityToCompany() {
        CompanyEntity companyEntity = new CompanyEntity("test1","TechCorp", DATA_TIME_TEST, Set.of());

        Company company = companyMapper.companyEntityToCompany(companyEntity);

        assertNotNull(company);
        assertEquals(companyEntity.getId(), company.getId());
        assertEquals(companyEntity.getName(), company.getName());
        assertEquals(companyEntity.getDateOfAccession(), company.getDateOfAccession());
    }

    @Test
    void testShouldMapCompanyToCompanyEntity() {
        Company company = Company.builder()
                .id("test2")
                .name("SoftDev")
                .dateOfAccession(DATA_TIME_TEST)
                .build();

        CompanyEntity companyEntity = companyMapper.companyToCompanyEntity(company);

        assertNotNull(companyEntity);
        assertEquals(company.getId(), companyEntity.getId());
        assertEquals(company.getName(), companyEntity.getName());
        assertEquals(company.getDateOfAccession(), companyEntity.getDateOfAccession());
    }

    @Test
    void testShouldMapCompanyDtoToCompany() {
        CompanyDto companyDto = CompanyDto.builder()
                .id("test3")
                .name("Innova")
                .dateOfAccession(DATA_TIME_TEST)
                .build();

        Company company = companyMapper.companyDtoToCompany(companyDto);

        assertNotNull(company);
        assertEquals(companyDto.getId(), company.getId());
        assertEquals(companyDto.getName(), company.getName());
        assertEquals(companyDto.getDateOfAccession(), company.getDateOfAccession());
    }

    @Test
    void testShouldMapCompanyToCompanyDto() {
        Company company = Company.builder()
                .id("test4")
                .name("NextGen")
                .dateOfAccession(DATA_TIME_TEST)
                .build();

        CompanyDto companyDto = companyMapper.companyToCompanyDto(company);

        assertNotNull(companyDto);
        assertEquals(company.getId(), companyDto.getId());
        assertEquals(company.getName(), companyDto.getName());
        assertEquals(company.getDateOfAccession(), companyDto.getDateOfAccession());
    }
}