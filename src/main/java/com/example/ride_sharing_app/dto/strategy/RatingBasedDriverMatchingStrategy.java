package com.example.ride_sharing_app.dto.strategy;

import com.example.ride_sharing_app.dto.Driver;
import com.example.ride_sharing_app.dto.Location;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

/**
 * Matches drivers by highest rating first — used for elite riders.
 * Among drivers with equal ratings, closer ones are preferred.
 */
@Component
public class RatingBasedDriverMatchingStrategy implements DriverMatchingStrategy {

    @Override
    public List<Driver> findMatchingDrivers(Location pickup, List<Driver> candidates, int maxResults) {
        return candidates.stream()
                .filter(d -> d.getCurrentLocation() != null)
                // Primary sort: highest rating first
                // Secondary sort: closest distance (tiebreaker)
                .sorted(Comparator.comparingDouble(Driver::getRating).reversed()
                        .thenComparingDouble(d -> haversineDistance(pickup, d.getCurrentLocation())))
                .limit(maxResults)
                .toList();
    }

    private double haversineDistance(Location a, Location b) {
        final double R = 6371.0;
        double dLat = Math.toRadians(b.getLatitude() - a.getLatitude());
        double dLon = Math.toRadians(b.getLongitude() - a.getLongitude());
        double lat1 = Math.toRadians(a.getLatitude());
        double lat2 = Math.toRadians(b.getLatitude());

        double x = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        return R * 2 * Math.atan2(Math.sqrt(x), Math.sqrt(1 - x));
    }
}
