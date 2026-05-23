package com.example.UberAuthService.controllers;

import com.example.UberAuthService.dto.*;
import com.example.UberAuthService.entities.Passenger;
import com.example.UberAuthService.services.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication APIs")
public class AuthController {

    private final AuthService authService;
    @Value("${cookie.expiry}")
    private int cookieExpiry;

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

    @Operation(summary = "Login User")
    @PostMapping("/login")
    public ApiResponse<?> login(
            @Valid
            @RequestBody
            LoginRequestDto loginRequest,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        LoginResponseDto loginResponse = authService.login(loginRequest);
        ResponseCookie cookie = ResponseCookie
                .from("accessToken", loginResponse.getAccessToken())
                .httpOnly(true)
                .secure(false)
                .path("/")
                .sameSite("Lax")
                .maxAge(cookieExpiry)
                .build();

        response.setHeader(HttpHeaders.SET_COOKIE, cookie.toString());

        return ApiResponse.builder()
                .success(true)
                .message("Login Successful")
                .data(
                        loginResponse.getUser()
                )
                .build();
    }

    @Operation(summary = "Logout User")
    @GetMapping("/logout")
    public ApiResponse<?> logout(HttpServletRequest request, HttpServletResponse response) {
        ResponseCookie cookie = ResponseCookie
                .from("accessToken", "")
                .httpOnly(true)
                .secure(false)
                .path("/")
                .maxAge(0)
                .build();
        response.setHeader(HttpHeaders.SET_COOKIE, cookie.toString());
        return ApiResponse.builder()
                .success(true)
                .message("Logged out successfully")
                .build();
    }

}

