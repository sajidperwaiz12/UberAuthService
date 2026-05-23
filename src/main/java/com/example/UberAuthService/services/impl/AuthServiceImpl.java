package com.example.UberAuthService.services.impl;

import com.example.UberAuthService.dto.DriverSignupRequestDto;
import com.example.UberAuthService.dto.PassengerSignupRequestDto;
import com.example.UberAuthService.dto.UserResponseDto;
import com.example.UberAuthService.entities.Driver;
import com.example.UberAuthService.entities.Passenger;
import com.example.UberAuthService.entities.enums.Role;
import com.example.UberAuthService.exception.EmailAlreadyExistsException;
import com.example.UberAuthService.exception.PhoneNumberAlreadyExistsException;
import com.example.UberAuthService.mapper.DriverMapper;
import com.example.UberAuthService.mapper.PassengerMapper;
import com.example.UberAuthService.repositories.DriverRepository;
import com.example.UberAuthService.repositories.PassengerRepository;
import com.example.UberAuthService.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final PassengerRepository passengerRepository;
    private final PassengerMapper passengerMapper;
    private final DriverRepository  driverRepository;
    private final DriverMapper driverMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDto registerPassenger(PassengerSignupRequestDto request) {
        validateUser(request.getEmail(), request.getPhoneNumber());

        Passenger passenger = passengerMapper.toEntity(request);
        passenger.setPassword(passwordEncoder.encode(request.getPassword()));
        passenger.setRole(Role.PASSENGER);
        Passenger savedPassenger = passengerRepository.save(passenger);
        return passengerMapper.toResponse(savedPassenger);
    }

    @Override
    public UserResponseDto registerDriver(DriverSignupRequestDto request) {
        validateUser(request.getEmail(), request.getPhoneNumber());

        Driver driver = driverMapper.toEntity(request);
        driver.setPassword(passwordEncoder.encode(request.getPassword()));
        driver.setRole(Role.DRIVER);
        Driver savedDriver = driverRepository.save(driver);
        return driverMapper.toResponse(savedDriver);
    }

    private void validateUser(String email, String phoneNumber) {
        boolean emailExists = passengerRepository.existsByEmail(email) || driverRepository.existsByEmail(email);

        if (emailExists) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        boolean phoneNumberExists = passengerRepository.existsByPhoneNumber(phoneNumber) || driverRepository.existsByPhoneNumber(phoneNumber);

        if (phoneNumberExists) {
            throw new PhoneNumberAlreadyExistsException("Phone number already exists");
        }
    }
}

