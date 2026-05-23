package com.example.UberAuthService.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "User Response")
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String role;
}

