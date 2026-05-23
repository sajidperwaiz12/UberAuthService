package com.example.UberAuthService.mapper;

import com.example.UberAuthService.dto.DriverSignupRequestDto;
import com.example.UberAuthService.dto.UserResponseDto;
import com.example.UberAuthService.entities.Driver;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DriverMapper {
    Driver toEntity(DriverSignupRequestDto request);
    UserResponseDto toResponse(Driver driver);
}

