package com.challenge.company.infrastructure.persistence.entity;

import com.challenge.transfer.infrastructure.persistence.entity.TransferEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Entity
@RequiredArgsConstructor
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, name = "name")
    private String name;

    @CreationTimestamp
    @Column(nullable = false, name = "date_of_accession")
    private LocalDateTime dateOfAccession;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "transfer")
    private Set<TransferEntity> clientCompanyUserSet;
}