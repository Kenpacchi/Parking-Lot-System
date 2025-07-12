package com.ParkingLotSystem.parkingSlotbooking.service;

import com.ParkingLotSystem.parkingSlotbooking.model.entities.Customer;
import com.ParkingLotSystem.parkingSlotbooking.model.entities.Floor;
import com.ParkingLotSystem.parkingSlotbooking.model.entities.Slot;
import com.ParkingLotSystem.parkingSlotbooking.repositories.CustomerRepository;
import com.ParkingLotSystem.parkingSlotbooking.repositories.FloorRepository;
import com.ParkingLotSystem.parkingSlotbooking.repositories.SlotRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingService {

    @Autowired
    private FloorRepository floorRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private SlotRepository slotRepository;

    public List<Map<String, Object>> showAvailableSlots(String mobileNumber, Long floorNumber, Long numberOfHours) {
        Customer customer=customerRepository.findByNumber(mobileNumber);
        Optional<Floor> floorOptional = floorRepository.findById(floorNumber);
        if (floorOptional.isEmpty()) {
            throw new RuntimeException("Floor not found with ID: " + floorNumber);
        }

        Floor floor = floorOptional.get();
        List<Slot> slots = floor.getSlots();

        List<Map<String, Object>> availableSlotsWithPrice = new ArrayList<>();

        for (Slot slot : slots) {
            if (!slot.isAvailable()) continue;

            Long vehicleLen = customer.getVehicle().getLength();
            Long vehicleWidth = customer.getVehicle().getWidth();
            Long slotLen = slot.getLength();
            Long slotWidth = slot.getWidth();
            if (slotLen >= vehicleLen && slotWidth >= vehicleWidth) {
                Long totalPrice = slot.getPricePerHour() * numberOfHours;
                Map<String, Object> slotDetails = new HashMap<>();
                slotDetails.put("slotId", slot.getId());
                slotDetails.put("length", slotLen);
                slotDetails.put("width", slotWidth);
                slotDetails.put("price", totalPrice);
                availableSlotsWithPrice.add(slotDetails);
            }
        }
        return availableSlotsWithPrice;
    }
    public String bookSlot(Long slotId, String mobileNumber, Long numberOfHours) {
        Customer customer=customerRepository.findByNumber(mobileNumber);
        Optional<Slot> slotOptional = slotRepository.findById(slotId);
        if (slotOptional.isEmpty()) {
            return "Slot not found with ID: " + slotId;
        }
        Slot slot = slotOptional.get();
        if (!slot.isAvailable()) {
            return "Slot is already booked.";
        }
        slot.setAvailable(false);
        slot.setCustomerId(customer.getId());
        slot.setPricePerHour(slot.getPricePerHour() * numberOfHours);
        slotRepository.save(slot);
        return "Slot booked successfully for " + numberOfHours + " hours.";
    }
    public String checkoutSlot(Long slotId) {
        Optional<Slot> slotOptional = slotRepository.findById(slotId);
        if (slotOptional.isEmpty()) {
            return "Slot not found with ID: " + slotId;
        }
        Slot slot = slotOptional.get();
        if (slot.isAvailable()) {
            return "Slot is already free.";
        }
        Long totalPrice = slot.getPricePerHour();
        slot.setAvailable(true);
        slot.setCustomerId(null);
        slot.setPricePerHour(0L);
        slotRepository.save(slot);

        return "Checkout successful. Total amount to pay: " + totalPrice;
    }
}
