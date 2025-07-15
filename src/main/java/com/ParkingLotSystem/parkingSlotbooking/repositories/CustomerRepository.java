package com.ParkingLotSystem.parkingSlotbooking.repositories;

import com.ParkingLotSystem.parkingSlotbooking.model.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{

    @Query(value = "SELECT * FROM Customer as c WHERE c.mobile_number=:mobileNumber", nativeQuery = true)
    Customer findByNumber(String mobileNumber);
}
