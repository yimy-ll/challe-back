package com.challenge.company.infrastructure.web.dto;

import com.challenge.transfer.infrastructure.web.TransferDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompanyDto {
    private String id;

    @NonNull
    @NotBlank(message = "La Razón Social (name) no puede estar vacía")
    @Size(min = 3, max = 100, message = "La Razón Social (neme) debe tener entre 3 y 100 caracteres")
    private String name;

    @NonNull
    private LocalDateTime dateOfAccession;
}