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
    private Long id;

    private Long pricePerHour;

    private boolean isAvailable;

    private Long floorNumber;

    private Long x;

    private Long y;

    private Long length;

    private Long width;

    private Long customerId;

    @ManyToOne
    @JoinColumn(name = "floor_id") // FK in Slot table pointing to Floor
    private Floor floor;
}
