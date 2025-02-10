package com.challenge.company.infrastructure.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompanyDto {
    private String id;

    @NotBlank(message = "La Razón Social (name) no puede estar vacía")
    @Size(min = 3, max = 100, message = "La Razón Social (neme) debe tener entre 3 y 100 caracteres")
    @Schema(description = "Razón Social de la empresa.", example = "Acme Inc.")
    private String name;

    @Schema(description = "Fecha de adhesión de la empresa.", example = "2024-07-11T14:50:00")
    private LocalDateTime dateOfAccession;
}