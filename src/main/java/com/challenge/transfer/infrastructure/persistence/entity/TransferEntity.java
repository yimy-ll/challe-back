package com.challenge.transfer.infrastructure.persistence.entity;

import com.challenge.transfer.domain.TransferType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Entity
@RequiredArgsConstructor
public class TransferEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    private String id;

    @Column(nullable = false, length = 50, name = "amount")
    private Double amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50, name = "transfer_type")
    private TransferType transferType;
}