package com.valuelabs.trackingnumber.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CustomerSlugValidator implements ConstraintValidator<ValidateCustomerSlug, String> {

    @Override
    public boolean isValid(String customerSlug, ConstraintValidatorContext constraintValidatorContext) {

        if (!customerSlug.matches("^[a-z\\-]+$")) {
            return false;
        }
        return true;
    }
}
