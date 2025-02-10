package com.challenge.company.domain.exception;

public class CompanyAlreadyExistsException extends RuntimeException {
    public CompanyAlreadyExistsException(String name) {
        super("La empresa con nombre '" + name + "' ya existe.");
    }
}
