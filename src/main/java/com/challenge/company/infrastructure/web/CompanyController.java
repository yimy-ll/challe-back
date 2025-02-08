package com.challenge.company.infrastructure.web;

import com.challenge.company.domain.CompanyService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
@Tag(name = "Company", description = "Company operations")
public class CompanyController {
    private final CompanyService companyService;
}
