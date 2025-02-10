package com.challenge.transfer.infrastructure.web.dto;

import com.challenge.company.infrastructure.web.dto.CompanyDto;
import com.challenge.transfer.domain.TransferType;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransferDto {
    private String id;

    @NotNull(message = "El monto no puede estar vacío")
    @Schema(description = "Monto de la transferencia", example = "100.0")
    private Double amount;

    @NotNull(message = "La empresa no puede estar vacía")
    private CompanyDto company;

    @NotNull(message = "El tipo de transferencia no puede estar vacío")
    private TransferType transferType;
    private LocalDateTime dateTransfer;
}