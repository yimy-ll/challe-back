package com.challenge.company.infrastructure.web;

import com.challenge.company.domain.Company;
import com.challenge.company.domain.CompanyService;
import com.challenge.company.infrastructure.CompanyMapper;
import com.challenge.company.infrastructure.web.dto.CompanyDto;
import com.challenge.company.infrastructure.web.filter.FilterCompany;
import com.challenge.response.infrastructure.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
@Tag(name = "Company", description = "Company operations")
public class CompanyController {
    private final CompanyService companyService;
    private final CompanyMapper companyMapper;

    @Operation(
            summary = "Obtener todas las empresas",
            description = "Obtiene una lista de todas las empresas, con la opción de filtrado por transferencias y fecha de adhesión.",
            tags = { "Companies" }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Empresas obtenidas con éxito",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = ResponseDto.class,
                                    description = "Respuesta exitosa con lista de empresas obtenidas.",
                                    example = "{\n" +
                                            "  \"status\": \"success\",\n" +
                                            "  \"message\": \"Empresas obtenidas con éxito\",\n" +
                                            "  \"data\": [\n" +
                                            "    {\n" +
                                            "      \"id\": \"1\",\n" +
                                            "      \"name\": \"Acme Inc.\",\n" +
                                            "      \"dateOfAccession\": \"2024-07-11T14:50:00\"\n" +
                                            "    }\n" +
                                            "  ]\n" +
                                            "}"
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error interno del servidor",
                    content = @Content(mediaType = "application/json")
            )
    })
    @GetMapping("/all")
    public ResponseEntity<ResponseDto> getAllCompanies(
            @Parameter(description = "Filtros para la búsqueda de empresas")
            @ParameterObject FilterCompany filter
    ) {
        List<Company> companies = companyService.findAll(filter);
        List<CompanyDto> companiesDto = companies.stream()
                .map(companyMapper::companyToCompanyDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(ResponseDto.builder()
                .status("success")
                .message("Empresas obtenidas con éxito")
                .data(companiesDto)
                .build());
    }
}