package com.challenge.utils;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDto {
    private String status;
    private String message;
    private Object data;
}