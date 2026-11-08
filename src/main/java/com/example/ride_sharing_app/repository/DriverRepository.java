package com.example.ride_sharing_app.repository;

import com.example.ride_sharing_app.dto.Driver;
import com.example.ride_sharing_app.dto.DriverStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver, String> {
    List<Driver> findByStatus(DriverStatus status);
}
