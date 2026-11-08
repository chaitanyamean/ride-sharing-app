package com.example.ride_sharing_app.repository;

import com.example.ride_sharing_app.dto.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiderRepository extends JpaRepository<Rider, String> {
    // findById, save, findAll etc. are inherited from JpaRepository
}
