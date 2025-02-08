package com.challenge.transfer.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Transfer {
    private String id;
    private Double amount;
    private TransferType transferType;
}