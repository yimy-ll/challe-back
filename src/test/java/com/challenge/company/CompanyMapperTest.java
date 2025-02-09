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
    void shouldMapCompanyEntityToCompany() {
        CompanyEntity entity = new CompanyEntity("TechCorp", DATA_TIME_TEST);

        Company company = companyMapper.companyEntityToCompany(entity);

        assertNotNull(company);
        assertEquals("TechCorp", company.getName());
        assertEquals(DATA_TIME_TEST, company.getDateOfAccession());
    }

    @Test
    void shouldMapCompanyToCompanyEntity() {
        Company company = new Company("SoftDev", DATA_TIME_TEST, Set.of());

        CompanyEntity entity = companyMapper.companyToCompanyEntity(company);

        assertNotNull(entity);
        assertEquals("SoftDev", entity.getName());
        assertEquals(DATA_TIME_TEST, entity.getDateOfAccession());
    }

    @Test
    void shouldMapCompanyDtoToCompany() {
        CompanyDto dto = new CompanyDto("Innova", DATA_TIME_TEST, Set.of());

        Company company = companyMapper.companyDtoToCompany(dto);

        assertEquals("Innova", company.getName());
        assertEquals(DATA_TIME_TEST, company.getDateOfAccession());
    }

    @Test
    void shouldMapCompanyToCompanyDto() {
        Company company = new Company("NextGen", DATA_TIME_TEST, Set.of());

        CompanyDto dto = companyMapper.companyToCompanyDto(company);

        assertNotNull(dto);
        assertEquals("NextGen", dto.getName());
        assertEquals(DATA_TIME_TEST, dto.getDateOfAccession());
    }
}