package com.challenge.company.infrastructure.web.filter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class FilterCompany {
    private String name;
    private Boolean companiesWithTransfersLastMonth;
    private Boolean companiesJoinedLastMonth;
}