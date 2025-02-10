package com.challenge.transfer.domain;

import com.challenge.company.domain.Company;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Transfer {
    private String id;
    private Double amount;
    private Company company;
    private TransferType transferType;
    private LocalDateTime dateTransfer;

    public String getCompanyId() {
        return company.getId();
    }
}