package com.challenge.company.infrastructure.web;

import com.challenge.company.domain.Company;
import com.challenge.company.domain.CompanyService;
import com.challenge.company.infrastructure.CompanyMapper;
import com.challenge.company.infrastructure.web.dto.CompanyDto;
import com.challenge.company.infrastructure.web.filter.FilterCompany;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
@Tag(name = "Company", description = "Company operations")
public class CompanyController {
    private final CompanyService companyService;
    private final CompanyMapper companyMapper;

    @GetMapping("/all")
    public ResponseEntity<List<CompanyDto>> getAllCompanies(@ParameterObject FilterCompany filter) {
        List<Company> companies = companyService .findAll();

        return ResponseEntity.ok(companies.stream().map(companyMapper::companyToCompanyDto).toList());
    }
}
