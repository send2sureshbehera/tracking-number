package com.valuelabs.trackingnumber.service;

import com.valuelabs.trackingnumber.dto.TrackingResponse;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public interface TrackingService {


    @Async
    CompletableFuture<TrackingResponse> getTrackingDetails(String originCountryId, String destinationCountry,
                                                           BigDecimal weight, OffsetDateTime createdAt, UUID customerId,
                                                           String customerName, String customerSlug);

}
