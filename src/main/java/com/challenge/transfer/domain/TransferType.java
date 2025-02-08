package com.challenge.transfer.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TransferType {
    CUENTA_DEBITO("Cuenta de Débito"),
    CUENTA_CREDITO("Cuenta de Crédito");

    private final String descripcion;
}
