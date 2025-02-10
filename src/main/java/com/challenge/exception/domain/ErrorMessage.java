package com.challenge.exception.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessage {
    @Schema(description = "Exception class name")
    private String exception;
    @Schema(description = "Exception message")
    private String message;
    @Schema(description = "Request path")
    private String path;
    @Schema(description = "Request timestamp")
    private LocalDateTime timestamp;
    private Map<String,String> errors;
}
