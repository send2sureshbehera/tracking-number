package com.valuelabs.trackingnumber.dto;

import java.time.OffsetDateTime;


public class TrackingResponse {

    private String tracking_number;
    private OffsetDateTime created_at;

    public String getTracking_number() {
        return tracking_number;
    }

    public void setTracking_number(String tracking_number) {
        this.tracking_number = tracking_number;
    }

    public OffsetDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(OffsetDateTime created_at) {
        this.created_at = created_at;
    }
}
