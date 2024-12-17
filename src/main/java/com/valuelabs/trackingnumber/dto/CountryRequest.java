package com.valuelabs.trackingnumber.dto;


import com.valuelabs.trackingnumber.service.TrackingServiceImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

@Getter
@Setter
@Service
public class CountryRequest {

    @Autowired
    private TrackingServiceImpl trackingServiceImpl;

    private String countrycode;
    private String destinationCountry;
    private String weight;
    String createdAt;
    String customerId;
    String customerName;
    String customerSlug;
/*

    public boolean validateCountryCode() {
        Object countryCode = trackingServiceImpl.getCountryCode();

        System.out.println(countryCode);

        if (((LinkedHashMap) countryCode).containsKey(countryCode)) {
            return true;
        } else
            return false;
    }*/
}
