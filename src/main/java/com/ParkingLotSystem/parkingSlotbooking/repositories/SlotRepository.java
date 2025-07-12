package com.ParkingLotSystem.parkingSlotbooking.repositories;

import com.ParkingLotSystem.parkingSlotbooking.model.entities.Slot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlotRepository extends JpaRepository<Slot,Long> {
}
