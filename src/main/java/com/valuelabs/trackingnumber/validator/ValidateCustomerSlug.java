package com.valuelabs.trackingnumber.validator;

import com.valuelabs.trackingnumber.validator.CustomerSlugValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CustomerSlugValidator.class)
@Target({ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateCustomerSlug {

        String message() default "Invalid Customer Slug \n (e.g., \\\"redbox-logistics\\\").\"";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};

    }
