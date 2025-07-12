package com.ParkingLotSystem.parkingSlotbooking.controller;

import com.ParkingLotSystem.parkingSlotbooking.model.dto.BookDTO;
import com.ParkingLotSystem.parkingSlotbooking.model.entities.Customer;
import com.ParkingLotSystem.parkingSlotbooking.service.BookingService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping(path="/api/bookSlot")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping(path = "/getAvailableSlots")
    List<Map<String, Object>> getAvailableSlotsWithPrice(@RequestParam String mobileNumber, @RequestParam Long floorNumber,@RequestParam Long numberOfHours){
        return bookingService.showAvailableSlots(mobileNumber,floorNumber,numberOfHours);
    }
    @PostMapping(path = "/bookSlot")
    private String bookSlot(@RequestBody BookDTO bookDTO){
        return bookingService.bookSlot(bookDTO.getSlotId(),bookDTO.getMobileNumber(),bookDTO.getNumberOfHours());
    }
    @PostMapping(path ="vacantSlot")
    private String bookSlot(@RequestParam Long slotId){
        return bookingService.checkoutSlot(slotId);
    }
}
