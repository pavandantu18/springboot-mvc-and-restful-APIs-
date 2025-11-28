package com.example.mvcArchitecture.dto;

import com.example.mvcArchitecture.annotations.PasswordValidation;
import com.example.mvcArchitecture.annotations.PrimeNumberValidation;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {

    private Long id;

    @NotBlank(message = "Department Title cannot be blank")
    private String title;

    @AssertTrue(message = "Department should be active")
    @JsonProperty("isActive")
    private Boolean isActive;

    @PastOrPresent(message = "Created date cannot be from future")
    private LocalDate createdAt;

    @PrimeNumberValidation
    private Integer num;

    @PasswordValidation
    private String password;

    @NotBlank(message = "Card number is required")
    @CreditCardNumber
    private String cardNumber;

    @URL(message = "Please provide a valid website address")
    private String websiteUrl;

    // @Min / @Max: Checks integer range
    @Min(value = 1, message = "Floor number must be 1 or higher") // @Min
    @Max(value = 99, message = "Floor number must be 99 or lower") // @Max
    private Integer floorNumber;

    // @Negative / @NegativeOrZero: (Less common here, but for demonstration)
    @Negative(message = "Budget allocation must be negative for internal accounting") // @Negative
    private Integer negativeAllocation;

    // @DecimalMin / @DecimalMax: Checks BigDecimal range
    @DecimalMin(value = "1000.00", message = "Minimum budget is 1000.00") // @DecimalMin
    @DecimalMax(value = "999999.99", message = "Maximum budget is 999999.99") // @DecimalMax
    @Digits(integer = 6, fraction = 2, message = "Budget must have up to 6 digits and 2 decimals") // @Digits
    private BigDecimal annualBudget;

    @Null(message = "Temporary code must be null on submission")
    private String tempCode;

    @AssertFalse(message = "Department must not be merged yet") // @AssertFalse
    private Boolean isMerged;
}
