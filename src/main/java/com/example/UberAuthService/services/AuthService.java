package com.example.UberAuthService.services;

import com.example.UberAuthService.dto.*;
import jakarta.validation.Valid;

public interface AuthService {

    UserResponseDto registerPassenger(@Valid PassengerSignupRequestDto request);

    UserResponseDto registerDriver(@Valid DriverSignupRequestDto request);

    LoginResponseDto login(@Valid LoginRequestDto request);
}

