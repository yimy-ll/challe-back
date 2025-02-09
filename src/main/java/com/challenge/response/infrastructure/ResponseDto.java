package com.challenge.response.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class ResponseDto {
    private String status;
    private String message;
    private Object data;
}