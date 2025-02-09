package com.challenge.company.domain;

import com.challenge.transfer.domain.Transfer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@RequiredArgsConstructor
public class Company {
    private String id;

    @NonNull
    private String name;

    @NonNull
    private LocalDateTime dateOfAccession;
}
