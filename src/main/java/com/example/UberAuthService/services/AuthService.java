package com.example.UberAuthService.services;

import com.example.UberAuthService.dto.DriverSignupRequestDto;
import com.example.UberAuthService.dto.PassengerSignupRequestDto;
import com.example.UberAuthService.dto.UserResponseDto;
import jakarta.validation.Valid;

public interface AuthService {

    UserResponseDto registerPassenger(@Valid PassengerSignupRequestDto request);

    UserResponseDto registerDriver(@Valid DriverSignupRequestDto request);
}

