package com.example.UberAuthService.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Passenger Signup Request")
public class PassengerSignupRequestDto {
    @Schema(example = "Sajid Mallick")
    @NotBlank
    private String name;

    @Schema(example = "sajid@gmail.com")
    @NotBlank
    @Email
    private String email;

    @Schema(example = "9876543210")
    @NotBlank
    private String phoneNumber;

    @Schema(example = "password@123")
    @Size(min = 6)
    private String password;

    @Schema(example = "Dhanbad, Jharkhand")
    private String homeAddress;
}

