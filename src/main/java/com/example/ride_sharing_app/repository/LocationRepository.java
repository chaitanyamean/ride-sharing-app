package com.example.ride_sharing_app.repository;

import com.example.ride_sharing_app.dto.Location;

public interface LocationRepository {
    void saveLocation(String driverId, Location location);

    Location getLatestLocation(String driverId);
}
