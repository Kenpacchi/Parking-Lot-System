package com.ParkingLotSystem.parkingSlotbooking.repositories;

import com.ParkingLotSystem.parkingSlotbooking.model.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
}
