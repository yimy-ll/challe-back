package com.challenge.company.infrastructure.persistence.specification;

import com.challenge.company.infrastructure.persistence.entity.CompanyEntity;
import com.challenge.company.infrastructure.web.filter.FilterCompany;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class CompanySpecifications {
    public static Specification<CompanyEntity> findStockByFilter(FilterCompany filter) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> criteriaList = new ArrayList<>();
            LocalDate lastMonth = LocalDate.now().withDayOfMonth(1);

            if (Boolean.TRUE.equals(filter.getCompaniesJoinedLastMonth())) {
                criteriaList.add(criteriaBuilder.greaterThanOrEqualTo(root.get("dateOfAccession"), lastMonth));
            }

            if (Boolean.TRUE.equals(filter.getCompaniesWithTransfersLastMonth())) {
                Join<Object, Object> transferJoin = root.join("transfers");
                criteriaList.add(criteriaBuilder.greaterThanOrEqualTo(transferJoin.get("dateTransfer"), lastMonth));
            }

            if(StringUtils.hasText(filter.getName())) {
                criteriaList.add(criteriaBuilder.like(criteriaBuilder.upper(root.get("name")),"%" + filter.getName().toUpperCase() + "%"));
            }

            return criteriaBuilder.and(criteriaList.toArray(new Predicate[criteriaList.size()]));
        };
    }
}