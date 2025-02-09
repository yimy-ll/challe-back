package com.challenge.transfer.infrastructure.web;

import com.challenge.transfer.domain.TransferType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransferDto {
    private String id;
    private Double amount;
    private TransferType transferType;
}
