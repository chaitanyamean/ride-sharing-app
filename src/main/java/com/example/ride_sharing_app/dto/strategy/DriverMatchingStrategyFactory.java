package com.example.ride_sharing_app.dto.strategy;

import com.example.ride_sharing_app.repository.RiderRepository;
import org.springframework.stereotype.Component;

/**
 * Factory that picks the correct DriverMatchingStrategy at runtime
 * based on whether the rider is elite or not.
 *
 * - Elite rider  → RatingBasedDriverMatchingStrategy  (top-rated drivers first)
 * - Normal rider → ProximityDriverMatchingStrategy    (nearest drivers first)
 */
@Component
public class DriverMatchingStrategyFactory {

    private final RiderRepository riderRepository;
    private final RatingBasedDriverMatchingStrategy ratingBasedStrategy;
    private final ProximityDriverMatchingStrategy proximityStrategy;

    public DriverMatchingStrategyFactory(RiderRepository riderRepository,
                                         RatingBasedDriverMatchingStrategy ratingBasedStrategy,
                                         ProximityDriverMatchingStrategy proximityStrategy) {
        this.riderRepository = riderRepository;
        this.ratingBasedStrategy = ratingBasedStrategy;
        this.proximityStrategy = proximityStrategy;
    }

    /**
     * Returns the appropriate strategy for the given rider.
     *
     * @param riderId the ID of the rider requesting the ride
     * @return RatingBasedDriverMatchingStrategy for elite riders,
     *         ProximityDriverMatchingStrategy for normal riders
     */
    public DriverMatchingStrategy getStrategy(String riderId) {
        boolean isElite = riderRepository.findById(riderId)
                .map(rider -> rider.isElite())
                .orElse(false); // default to normal if rider not found

        if (isElite) {
            return ratingBasedStrategy;
        }
        return proximityStrategy;
    }
}
