package com.example.ride_sharing_app.repository;

import com.example.ride_sharing_app.dto.Rider;

import java.util.Optional;

public interface RiderRepository {

    Optional<Rider> findById(String id);

    void save(Rider rider);
}
