package com.challenge.company.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class Company {
    private String id;
    private String name;
    private LocalDateTime dateOfAccession;
}
