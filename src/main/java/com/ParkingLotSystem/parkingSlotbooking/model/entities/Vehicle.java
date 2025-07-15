package com.ParkingLotSystem.parkingSlotbooking.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // maps to `id` in the table
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "vehicle_number", unique = true, nullable = false, length = 50)
    private String vehicleNumber;

    @Column(name = "length", nullable = false)
    private Long length;

    @Column(name = "width", nullable = false)
    private Long width;

}
