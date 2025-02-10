package com.challenge.exception.infrastructure;

import com.challenge.company.domain.exception.CompanyAlreadyExistsException;
import com.challenge.company.domain.exception.CompanyNotFoundException;
import com.challenge.exception.domain.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(CompanyAlreadyExistsException.class)
    public ErrorMessage handleCompanyAlreadyExistsException(CompanyAlreadyExistsException ex, ServletWebRequest request) {
        return ErrorMessage.builder()
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .exception(ex.getClass().getSimpleName())
                .path(request.getRequest().getRequestURI())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CompanyNotFoundException.class)
    public ErrorMessage handleCompanyNotFoundException(CompanyNotFoundException ex, ServletWebRequest request) {
        return ErrorMessage.builder()
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .exception(ex.getClass().getSimpleName())
                .path(request.getRequest().getRequestURI())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorMessage handleMethodArgumentNotValid(MethodArgumentNotValidException ex, ServletWebRequest request) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        return ErrorMessage.builder()
                .path(request.getRequest().getRequestURI())
                .exception(ex.getClass().getSimpleName())
                .message("Se encontraron errores en la solicitud.")
                .timestamp(LocalDateTime.now())
                .errors(errors)
                .build();
    }
}