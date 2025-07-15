package com.ParkingLotSystem.parkingSlotbooking.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="slot")
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // maps to `id` in the table
    private Long id;

    @Column(name = "price_per_hour", nullable = false)
    private Long pricePerHour;

    @Column(name = "is_available", nullable = false)
    private boolean isAvailable;

    @Column(name = "floor_number", nullable = false)
    private Long floorNumber;

    @Column(name = "x", nullable = false)
    private Long x;

    @Column(name = "y", nullable = false)
    private Long y;

    @Column(name = "length", nullable = false)
    private Long length;

    @Column(name = "width", nullable = false)
    private Long width;

    @Column(name = "customer_id")
    private Long customerId;

    @ManyToOne
    @JoinColumn(name = "floor_id", referencedColumnName = "id", nullable = false)
    private Floor floor;
}
