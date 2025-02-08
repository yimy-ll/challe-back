package com.challenge.transfer.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Transfer {
    @Id
    @GeneratedValue(generator = "uuid")
    private String id;
}
