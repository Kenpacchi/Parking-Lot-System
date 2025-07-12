package com.ParkingLotSystem.parkingSlotbooking.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDTO {

    private String name;
    private String mobileNumber;
    private String password;
    private String vehicleNumber;
    private Long vehicleLength;
    private Long vehicleWidth;
    private String vehicleName;
}
