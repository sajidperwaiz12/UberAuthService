package com.example.UberAuthService.entities;

import com.example.UberAuthService.entities.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "drivers")
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class Driver extends User {

    private String licenseNumber;

    private String aadhaarCard;

    private String vehicleNumber;

    private String vehicleType;

    private Boolean available = true;

    public Driver() {
        setRole(Role.DRIVER);
    }

}

