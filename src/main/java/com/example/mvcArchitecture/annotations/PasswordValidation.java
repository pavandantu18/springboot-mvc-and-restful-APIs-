package com.example.mvcArchitecture.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = {PasswordValidator.class})
public @interface PasswordValidation {
    String message() default "Make sure password a.contains one uppercase letter b. contains one lowercase letter c. contains one special character d. minimum length is 10 characters";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
