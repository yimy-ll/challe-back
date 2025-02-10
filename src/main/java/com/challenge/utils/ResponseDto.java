package com.challenge.utils;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDto {
    @Schema(description = "Estado de la respuesta", example = "success")
    private String status;
    @Schema(description = "Mensaje de la respuesta", example = "Operación exitosa")
    private String message;
    @Schema(description = "Datos de la respuesta")
    private Object data;
}