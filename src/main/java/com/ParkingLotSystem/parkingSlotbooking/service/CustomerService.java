package com.ParkingLotSystem.parkingSlotbooking.service;

import com.ParkingLotSystem.parkingSlotbooking.model.dto.SignUpDTO;
import com.ParkingLotSystem.parkingSlotbooking.model.entities.Customer;
import com.ParkingLotSystem.parkingSlotbooking.model.entities.Vehicle;
import com.ParkingLotSystem.parkingSlotbooking.repositories.CustomerRepository;
import com.ParkingLotSystem.parkingSlotbooking.repositories.VehicleRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

    public String authCheck(String mobileNumber,String password){
        Customer customer=customerRepository.findByNumber(mobileNumber);
        if(customer==null){
            return "Customer Not Exist Please Sign Up";
        }
        if(Objects.equals(customer.getPassword(), password)){
            return "Login Successfully";
        }else{
            return "Incorrect Password";
        }
    }
    public String signUp(SignUpDTO signUpDTO) {
        if(customerRepository.findByNumber(signUpDTO.getMobileNumber())!=null){
            return "Mobile Number Already Exist!";
        }
        Customer customer = new Customer();
        customer.setName(signUpDTO.getName());
        customer.setMobileNumber(signUpDTO.getMobileNumber());
        customer.setPassword(signUpDTO.getPassword());
        Vehicle vehicle = new Vehicle();
        vehicle.setName(signUpDTO.getVehicleName());
        vehicle.setLength(signUpDTO.getVehicleLength());
        vehicle.setWidth(signUpDTO.getVehicleWidth());
        vehicle.setVehicleNumber(signUpDTO.getVehicleNumber());
        customer.setVehicle(vehicle);
        vehicleRepository.save(vehicle);
        customerRepository.save(customer);
        return "Signup Success";
    }

}
