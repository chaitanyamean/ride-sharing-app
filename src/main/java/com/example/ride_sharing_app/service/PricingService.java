package com.example.ride_sharing_app.service;

import com.example.ride_sharing_app.dto.FareEstimateResponse;
import com.example.ride_sharing_app.dto.Location;
import com.example.ride_sharing_app.dto.strategy.PricingStrategy;

public class PricingService {
    private final PricingStrategy pricingStrategy;

    public PricingService(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public FareEstimateResponse estimateFare(Location pickup, Location dropoff, double distanceKm, long durationSec) {
        long fareMinor = pricingStrategy.calculateFare(pickup, dropoff, distanceKm, durationSec);
        return new FareEstimateResponse(fareMinor, distanceKm, durationSec, "USD");
    }
}
