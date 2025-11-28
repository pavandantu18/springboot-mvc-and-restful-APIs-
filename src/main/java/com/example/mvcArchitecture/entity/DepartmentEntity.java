package com.example.mvcArchitecture.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "department")
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @JsonProperty("isActive")
    private Boolean isActive;

    private LocalDate createdAt;

    private Integer num;

    private String password;

    private String cardNumber;

    private String websiteUrl;

    private Integer floorNumber;
    private Integer negativeAllocation;
    private BigDecimal annualBudget;

    private String tempCode;
    private Boolean isMerged;
}
