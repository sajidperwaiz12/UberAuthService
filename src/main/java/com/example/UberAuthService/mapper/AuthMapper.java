package com.example.UberAuthService.mapper;

import com.example.UberAuthService.dto.LoginResponseDto;
import com.example.UberAuthService.dto.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthMapper {

    @Mapping(target = "accessToken", source = "token")
    @Mapping(target = "user", source = "userResponseDto")
    LoginResponseDto toLoginResponse(String token, UserResponseDto userResponseDto);

}

