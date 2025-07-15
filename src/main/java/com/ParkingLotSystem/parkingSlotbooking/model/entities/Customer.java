package com.ParkingLotSystem.parkingSlotbooking.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "mobile_number", unique = true, nullable = false, length = 20)
    private String mobileNumber;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @OneToOne
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id", unique = true)
    private Vehicle vehicle;

}
