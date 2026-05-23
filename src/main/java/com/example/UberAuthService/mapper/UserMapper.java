package com.example.UberAuthService.mapper;

import com.example.UberAuthService.dto.UserResponseDto;
import com.example.UberAuthService.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDto toResponse(User user);
}

