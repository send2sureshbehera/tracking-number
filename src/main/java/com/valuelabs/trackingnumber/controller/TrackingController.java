package com.valuelabs.trackingnumber.controller;

import com.valuelabs.trackingnumber.dto.TrackingResponse;
import com.valuelabs.trackingnumber.service.TrackingService;
import com.valuelabs.trackingnumber.validator.ValidCountryCode;
import com.valuelabs.trackingnumber.validator.ValidateCustomerName;
import com.valuelabs.trackingnumber.validator.ValidateCustomerSlug;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.FutureOrPresent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.annotation.Async;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RequestMapping("/api/v1")
@RestController
@Validated
public class TrackingController {

    private static final Logger logger = LoggerFactory.getLogger(TrackingController.class);

    @Autowired
    private TrackingService trackingService;

    @GetMapping("/track")
    @Async
    public CompletableFuture<TrackingResponse> getTracking(
            @RequestParam @ValidCountryCode String origin_country_id,
            @RequestParam @ValidCountryCode String destination_country_id,
            @RequestParam @Digits(integer = 3, fraction = 3) BigDecimal weight,
            @RequestParam @FutureOrPresent @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime created_at,
            @RequestParam @Validated UUID customer_id,
            @RequestParam @ValidateCustomerName String customer_name,
            @RequestParam @ValidateCustomerSlug String customer_slug
    ) {

        logger.info("Inserting into Controller class {}", origin_country_id);

        CompletableFuture<TrackingResponse> responseCompletableFuture = trackingService.getTrackingDetails(origin_country_id, destination_country_id, weight,
                created_at, customer_id, customer_name, customer_slug);

        return responseCompletableFuture;

    }
}
