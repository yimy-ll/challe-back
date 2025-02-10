package com.challenge.transfer.infrastructure.web.dto;

import com.challenge.company.domain.Company;
import com.challenge.transfer.domain.TransferType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferDto {
    private String id;
    private Double amount;
    private String companyId;
    private TransferType transferType;
    private LocalDateTime dateTransfer;
}