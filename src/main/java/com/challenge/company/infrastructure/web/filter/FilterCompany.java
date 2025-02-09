package com.challenge.company.infrastructure.web.filter;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class FilterCompany {

    @Schema(description = "El nombre de la empresa que se busca.", example = "Acme Inc.")
    private String name;

    @Schema(description = "Filtra las empresas que realizaron transferencias el último mes.", example = "true")
    private Boolean companiesWithTransfersLastMonth;

    @Schema(description = "Filtra las empresas que se unieron el último mes.", example = "false")
    private Boolean companiesJoinedLastMonth;
}