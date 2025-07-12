package com.ParkingLotSystem.parkingSlotbooking.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="floor")
public class Floor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long floorNumber;

    private Long x;

    private Long y;

    @OneToMany(mappedBy = "floor", cascade = CascadeType.ALL)
    private List<Slot> slotList;

}
