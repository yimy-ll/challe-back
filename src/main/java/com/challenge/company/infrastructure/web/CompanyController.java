package com.challenge.company.infrastructure.web;

import com.challenge.company.domain.Company;
import com.challenge.company.domain.CompanyService;
import com.challenge.company.infrastructure.CompanyMapper;
import com.challenge.company.infrastructure.web.dto.CompanyDto;
import com.challenge.company.infrastructure.web.filter.FilterCompany;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(
            summary = "Obtiene todas las empresas",
            description = "Este endpoint obtiene todas las empresas, aplicando los filtros que se proporcionen a través del parámetro 'filter'.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Lista de empresas obtenida con éxito",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CompanyDto.class))
                    )
            }
    )
    @GetMapping("/all")
    public ResponseEntity<List<CompanyDto>> getAllCompanies(
            @Parameter(description = "Filtros para la búsqueda de empresas", required = false)
            @ParameterObject FilterCompany filter
    ) {
        List<Company> companies = companyService.findAll(filter);
        List<CompanyDto> companyDtos = companies.stream()
                .map(companyMapper::companyToCompanyDto)
                .toList();
        return ResponseEntity.ok(companyDtos);
    }
}