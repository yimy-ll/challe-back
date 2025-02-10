package com.challenge.transfer.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Transfer {
    private String id;
    private Double amount;
    private TransferType transferType;
    private LocalDateTime dateTransfer;
}