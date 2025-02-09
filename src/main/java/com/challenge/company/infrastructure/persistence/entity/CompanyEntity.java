package com.challenge.company.infrastructure.persistence.entity;

import com.challenge.transfer.infrastructure.persistence.entity.TransferEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Entity(name = "company")
@RequiredArgsConstructor
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, name = "name")
    @NonNull
    private String name;

    @NonNull
    @CreationTimestamp
    @Column(nullable = false, name = "date_of_accession")
    private LocalDateTime dateOfAccession;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "company")
    private Set<TransferEntity> transfers;
}