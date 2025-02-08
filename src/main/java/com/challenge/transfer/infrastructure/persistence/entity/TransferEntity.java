package com.challenge.transfer.infrastructure.persistence.entity;

import com.challenge.company.infrastructure.persistence.entity.CompanyEntity;
import com.challenge.transfer.domain.TransferType;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Entity
@RequiredArgsConstructor
public class TransferEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(nullable = false, length = 50, name = "amount")
    private Double amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50, name = "transfer_type")
    private TransferType transferType;

    @CreationTimestamp
    @Column(nullable = false, name = "date_of_transfer")
    private LocalDateTime dateTransfer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    @EqualsAndHashCode.Exclude
    private CompanyEntity company;
}