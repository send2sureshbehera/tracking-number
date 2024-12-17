package com.valuelabs.trackingnumber.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CustomerNameValidator implements ConstraintValidator<ValidateCustomerName, String> {

    @Override
    public boolean isValid(String customerName, ConstraintValidatorContext constraintValidatorContext) {

        if (!customerName.matches("^[a-zA-Z ]*$")) {
            return false;
        }
        return true;
    }
}
