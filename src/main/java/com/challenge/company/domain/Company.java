package com.challenge.company.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
public class Company {
    private String id;

    private String name;

    private LocalDateTime dateOfAccession;
}
