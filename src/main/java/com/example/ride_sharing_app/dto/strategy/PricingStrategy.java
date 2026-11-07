package com.example.ride_sharing_app.dto.strategy;

import com.example.ride_sharing_app.dto.Location;

public interface PricingStrategy {
    long calculateFare(Location pickup, Location dropoff, double distanceKm, long durationSec);
}
