package com.example.ride_sharing_app.controller;

import com.example.ride_sharing_app.dto.Driver;
import com.example.ride_sharing_app.service.DriverService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {
    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping
    public String addDriver(@RequestBody Driver driver) {
        return driverService.addDriver(driver);
    }

    @GetMapping
    public String getDrivers() {
        return "Drivers";
    }

}
