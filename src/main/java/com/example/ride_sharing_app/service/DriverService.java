package com.example.ride_sharing_app.service;

import com.example.ride_sharing_app.dto.Driver;
import com.example.ride_sharing_app.dto.DriverStatus;
import com.example.ride_sharing_app.dto.Location;
import com.example.ride_sharing_app.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository){
        this.driverRepository = driverRepository;
    }

    public void goOnline(String driverId) {
        Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new IllegalArgumentException("Driver not found"));
        driver.setStatus(DriverStatus.ONLINE);
        driverRepository.save(driver);
    }

    public void goOffline(String driverId) {
        Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new IllegalArgumentException("Driver not found"));
        driver.setStatus(DriverStatus.OFFLINE);
        driverRepository.save(driver);
    }

    public void updateLocation(String driverId, Location location) {
        Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new IllegalArgumentException("Driver not found"));
        driver.setCurrentLocation(location);
        driver.setLastLocationUpdate(location.getTimestamp());
        driverRepository.save(driver);
    }

    public Optional<Driver> findById(String driverId) {
        return driverRepository.findById(driverId);
    }

    public String addDriver(Driver driver) {
            driverRepository.save(driver);
            return "Added Driver";
    }


}
