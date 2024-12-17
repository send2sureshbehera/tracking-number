package com.valuelabs.trackingnumber.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tracking {

    @Id
    @Column(name = "TRACKING_NUMBER")
    private String trackingNumber;

    @Column(name = "ORIGIN_COUNTRY_CODE")
    private String orgiginCountryCode;

    @Column(name = "DESTINATION_COUNTRY_ID")
    private String destinationCountryId;

    @Column(name = "WEIGHT")
    private BigDecimal weight;

    @Column(name = "CREATED_AT")
    private OffsetDateTime createdDate;

    @Column(name = "CUSTOMER_ID")
    private String customerId;

    @Column(name = "CUSTOMER_NAME")
    private String customerName;

    @Column(name = "CUSTOMER_SLUG")
    private String customerSlug;

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getOrgiginCountryCode() {
        return orgiginCountryCode;
    }

    public void setOrgiginCountryCode(String orgiginCountryCode) {
        this.orgiginCountryCode = orgiginCountryCode;
    }

    public String getDestinationCountryId() {
        return destinationCountryId;
    }

    public void setDestinationCountryId(String destinationCountryId) {
        this.destinationCountryId = destinationCountryId;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public OffsetDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(OffsetDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSlug() {
        return customerSlug;
    }

    public void setCustomerSlug(String customerSlug) {
        this.customerSlug = customerSlug;
    }
}
