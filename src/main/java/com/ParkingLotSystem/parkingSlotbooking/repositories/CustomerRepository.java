package com.ParkingLotSystem.parkingSlotbooking.repositories;

import com.ParkingLotSystem.parkingSlotbooking.model.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long>{
}
