package com.challenge.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseErrorDto<T> {
    private String status;
    private String message;
    private String errorCode;
    private T details;
}
