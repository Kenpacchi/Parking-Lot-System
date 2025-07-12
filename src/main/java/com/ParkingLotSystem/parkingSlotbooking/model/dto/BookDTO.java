package com.ParkingLotSystem.parkingSlotbooking.model.dto;

import lombok.Data;

@Data
public class BookDTO {

    private Long slotId;
    private String mobileNumber;
    private Long numberOfHours;
}
