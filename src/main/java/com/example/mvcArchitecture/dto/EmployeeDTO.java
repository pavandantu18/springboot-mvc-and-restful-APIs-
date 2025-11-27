package com.example.mvcArchitecture.dto;

import com.example.mvcArchitecture.annotations.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;

    @NotBlank(message = "Name of the employee cannot be blank")
    @Size(min=3,max=10,message = "Number of characters in name should be in the range [3-10]")
    private String name;

    @NotBlank(message = "Email of the employee cannot be blank")
    @Email(message = "Email should be a valid email")
    private String email;

    @NotNull(message = "Age of the employee cannot be blank")
    @Max(value = 80, message = "Age cannot be greater than 80")
    @Min(value = 18, message = "Age cannot be less than 18")
    private Integer age;

    @NotBlank(message = "Role of the employee cannot be blank")
//    @Pattern(regexp = "^(ADMIN|USER)$", message = "Role of the employee can either be ADMIN or USER")
    @EmployeeRoleValidation
    private String role; //ADMIN, USER

    @NotNull(message = "Salary of the employee should not be null")
    @Positive(message = "Salary of Employee should be positive")
    @Digits(integer = 6,fraction = 2,message = "The salary can be in the form XXXXXX.YY")
    @DecimalMax(value = "100000.99")
    @DecimalMin(value = "100.50")
    private Double salary;

    @PastOrPresent(message = "Date of joining field cannot be in future")
    private LocalDate dateOfJoining;

    @AssertTrue(message = "Employee should be active")
    @JsonProperty("isActive")
    private Boolean isActive;
}
