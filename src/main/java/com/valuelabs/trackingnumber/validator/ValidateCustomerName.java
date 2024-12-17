package com.valuelabs.trackingnumber.validator;

import com.valuelabs.trackingnumber.validator.CustomerNameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CustomerNameValidator.class)
@Target({ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateCustomerName {

        String message() default "Invalid Customer name \n (e.g., \\\"RedBox Logistics\\\").\"";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};

    }
