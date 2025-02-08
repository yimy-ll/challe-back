package com.challenge.company.infrastructure.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompanyDto {
    private String id;

    @NotBlank(message = "La Razón Social (name) no puede estar vacía")
    @Size(min = 3, max = 100, message = "La Razón Social (neme) debe tener entre 3 y 100 caracteres")
    private String name;

    private LocalDateTime dateOfAccession;
}