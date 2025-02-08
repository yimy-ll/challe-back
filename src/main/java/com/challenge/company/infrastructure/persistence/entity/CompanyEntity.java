package com.challenge.company.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;

import java.time.LocalDateTime;

@Getter
@Entity
@RequiredArgsConstructor
public class CompanyEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    private String id;

    @Column(nullable = false, name = "name")
    private String name;

    @CreationTimestamp
    @Column(nullable = false, name = "date_of_accession")
    private LocalDateTime dateOfAccession;
}