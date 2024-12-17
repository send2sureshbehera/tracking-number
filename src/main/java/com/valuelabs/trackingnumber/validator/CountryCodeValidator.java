package com.valuelabs.trackingnumber.validator;

import com.valuelabs.trackingnumber.service.TrackingServiceImpl;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashMap;

public class CountryCodeValidator implements ConstraintValidator<ValidCountryCode, String> {

    @Autowired
    TrackingServiceImpl trackingServiceImpl;


    @Override
    public boolean isValid(String countryCode, ConstraintValidatorContext constraintValidatorContext) {

        Object countryCodeObj = trackingServiceImpl.getCountryCode();

        System.out.println(countryCodeObj);

        if (((LinkedHashMap) countryCodeObj).containsKey(countryCode)) {
            return true;
        } else
            return false;

    }
}
