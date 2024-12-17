package com.valuelabs.trackingnumber.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.valuelabs.trackingnumber.dto.TrackingResponse;
import com.valuelabs.trackingnumber.entity.Tracking;
import com.valuelabs.trackingnumber.repository.TrackingRepsository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.*;
import java.util.concurrent.CompletableFuture;

@Service
public class TrackingServiceImpl implements TrackingService {
    private static final Logger logger = LoggerFactory.getLogger(TrackingServiceImpl.class);


    @Autowired
    TrackingRepsository trackingRepsository;

    @Override
    @Async
    public CompletableFuture<TrackingResponse> getTrackingDetails(String originCountryId, String destinationCountry,
                                                                  BigDecimal weight, OffsetDateTime createdAt,
                                                                  UUID customerId, String customerName,
                                                                  String customerSlug) {

        logger.info("********************Data process starts **********************");
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("originCountryId", originCountryId);
        parameter.put("destinationCountry", destinationCountry);
        parameter.put("weight", weight);
        parameter.put("createdAt", createdAt);
        parameter.put("customerId", customerId);
        parameter.put("customerName", customerName);
        parameter.put("customerSlug", customerSlug);


        String regex = "^[A-Z0-9]{1,16}$";
        String trackNo = generateRandom(16);
        TrackingResponse response = new TrackingResponse();
        if (trackNo.matches(regex)) {
            checkTheDuplicateRecord(parameter, trackNo);

            response.setTracking_number(trackNo);
            response.setCreated_at(createdAt);
        }
        return CompletableFuture.completedFuture(response);
    }

    private String checkTheDuplicateRecord(Map<String, Object> parameter, String trackNo) {
        Optional<Tracking> trackId = trackingRepsository.findById(trackNo);

        if (!trackId.isPresent()) {
            saveTrackDetails(trackNo, parameter);
        } else {
            trackNo = generateRandom(16);
        }
        return trackNo;
    }

    private void saveTrackDetails(String trackNo, Map<String, Object> parameter) {

        logger.info("Enterd into saveTrackDetails method to save the data into database ");
        Tracking tracking = new Tracking();

        tracking.setTrackingNumber(trackNo);
        tracking.setOrgiginCountryCode(parameter.get("originCountryId").toString());
        tracking.setDestinationCountryId(parameter.get("destinationCountry").toString());
        tracking.setWeight((BigDecimal) parameter.get("weight"));
        tracking.setCreatedDate((OffsetDateTime) parameter.get("createdAt"));
        tracking.setCustomerId(parameter.get("customerId").toString());
        tracking.setCustomerName(parameter.get("customerName").toString());
        tracking.setCustomerSlug(parameter.get("customerSlug").toString());

        Tracking save = trackingRepsository.save(tracking);
        logger.info("Save the data into data base {}", save.getTrackingNumber());
    }

    public String generateRandom(int no) {
        logger.info("Entered into generateRandom method to create random tracking number ");
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < no; i++) {
            int incdex = random.nextInt(str.length());
            sb.append(str.charAt(incdex));
        }
        return sb.toString();
    }

    public Object getCountryCode() {

        logger.info("entered into getCountryCode to fetch the country short names");

        Map<String, String> map = new LinkedHashMap();

        ClassPathResource resource = new ClassPathResource("static/countryCode.json");
        ObjectMapper mapper = new ObjectMapper();
        try {
            map = mapper.readValue(resource.getInputStream(), Map.class);
        } catch (IOException e) {
            logger.error("Error occures while fetching the from File");
        }
        return map;
    }
}
