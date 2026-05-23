package com.example.UberAuthService.controllers;

import com.example.UberAuthService.dto.ApiResponse;
import com.example.UberAuthService.dto.DriverSignupRequestDto;
import com.example.UberAuthService.dto.PassengerSignupRequestDto;
import com.example.UberAuthService.dto.UserResponseDto;
import com.example.UberAuthService.entities.Passenger;
import com.example.UberAuthService.services.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication APIs")
public class AuthController {

    private final AuthService authService;

    @Operation(summary = "Register Passenger")
    @PostMapping("/register/passenger")
    public ApiResponse<UserResponseDto> registerPassenger(
            @Valid
            @RequestBody
            PassengerSignupRequestDto request
    ) {
        return ApiResponse.<UserResponseDto>builder()
                .success(true)
                .message("Passenger registered successfully")
                .data(
                        authService.registerPassenger(request)
                )
                .build();
    }

    @Operation(summary = "Register Driver")
    @PostMapping("/register/driver")
    public ApiResponse<UserResponseDto> registerDriver(
            @Valid
            @RequestBody
            DriverSignupRequestDto request
    ) {
        return ApiResponse.<UserResponseDto>builder()
                .success(true)
                .message("Driver registered successfully")
                .data(
                        authService.registerDriver(request)
                )
                .build();
    }

}

