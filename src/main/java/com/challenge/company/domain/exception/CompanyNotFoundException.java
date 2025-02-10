package com.challenge.company.domain.exception;

public class CompanyNotFoundException extends RuntimeException {
    public CompanyNotFoundException(String companyId) {
        super("Empresa con id " + companyId + " no encontrada.");
    }
}
