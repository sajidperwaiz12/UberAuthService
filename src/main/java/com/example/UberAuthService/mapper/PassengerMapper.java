package com.example.UberAuthService.mapper;

import com.example.UberAuthService.dto.PassengerSignupRequestDto;
import com.example.UberAuthService.dto.UserResponseDto;
import com.example.UberAuthService.entities.Passenger;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PassengerMapper {
    Passenger toEntity(PassengerSignupRequestDto request);
    UserResponseDto toResponse(Passenger passenger);
}

