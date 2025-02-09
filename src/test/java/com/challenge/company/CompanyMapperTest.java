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
        CompanyEntity entity = new CompanyEntity("test1","TechCorp", DATA_TIME_TEST, Set.of());

        Company company = companyMapper.companyEntityToCompany(entity);

        assertNotNull(company);
        assertEquals("test1", company.getId());
        assertEquals("TechCorp", company.getName());
        assertEquals(DATA_TIME_TEST, company.getDateOfAccession());
    }

    @Test
    void shouldMapCompanyToCompanyEntity() {
        Company company = Company.builder()
                .id("test2")
                .name("SoftDev")
                .dateOfAccession(DATA_TIME_TEST)
                .build();

        CompanyEntity entity = companyMapper.companyToCompanyEntity(company);

        assertNotNull(entity);
        assertEquals("test2", entity.getId());
        assertEquals("SoftDev", entity.getName());
        assertEquals(DATA_TIME_TEST, entity.getDateOfAccession());
    }

    @Test
    void shouldMapCompanyDtoToCompany() {
        CompanyDto dto = CompanyDto.builder()
                .id("test3")
                .name("Innova")
                .dateOfAccession(DATA_TIME_TEST)
                .build();

        Company company = companyMapper.companyDtoToCompany(dto);

        assertNotNull(company);
        assertEquals("test3", company.getId());
        assertEquals("Innova", company.getName());
        assertEquals(DATA_TIME_TEST, company.getDateOfAccession());
    }

    @Test
    void shouldMapCompanyToCompanyDto() {
        Company company = Company.builder()
                .id("test4")
                .name("NextGen")
                .dateOfAccession(DATA_TIME_TEST)
                .build();

        CompanyDto dto = companyMapper.companyToCompanyDto(company);

        assertNotNull(dto);
        assertEquals("test4", dto.getId());
        assertEquals("NextGen", dto.getName());
        assertEquals(DATA_TIME_TEST, dto.getDateOfAccession());
    }
}