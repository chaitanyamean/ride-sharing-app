package com.example.ride_sharing_app.dto.strategy;

import com.example.ride_sharing_app.dto.Driver;
import com.example.ride_sharing_app.dto.Location;

import java.util.List;

public interface DriverMatchingStrategy {
    List<Driver> findMatchingDrivers(Location pickup, List<Driver> candidates, int maxResults);
}
