package com.ParkingLotSystem.parkingSlotbooking.controller;

import com.ParkingLotSystem.parkingSlotbooking.model.dto.LoginDTO;
import com.ParkingLotSystem.parkingSlotbooking.model.dto.SignUpDTO;
import com.ParkingLotSystem.parkingSlotbooking.model.entities.Customer;
import com.ParkingLotSystem.parkingSlotbooking.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path="/authenticate")
    public String authController(@RequestBody LoginDTO loginDTO){
        return customerService.authCheck(loginDTO.getMobileNumber(),loginDTO.getPassword());
    }
    @PostMapping(path="/signUp")
    public String signUp(@RequestBody SignUpDTO signupDto){
        return customerService.signUp(signupDto);
    }
}
