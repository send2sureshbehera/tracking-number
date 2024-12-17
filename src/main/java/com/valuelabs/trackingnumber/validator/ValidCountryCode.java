package com.valuelabs.trackingnumber.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CountryCodeValidator.class)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCountryCode {

    String message() default "Invalid Country Code \n Country code should be alpha-2 format (e.g., \\\"MY\\\").\"";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
