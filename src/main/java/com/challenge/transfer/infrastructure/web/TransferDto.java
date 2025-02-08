package com.challenge.transfer.infrastructure.web;

import com.challenge.transfer.domain.TransferType;
import lombok.Getter;

@Getter
public class TransferDto {
    private String id;
    private Double amount;
    private TransferType transferType;
}
