package com.example.UberAuthService.entities;

import com.example.UberAuthService.entities.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "passengers")
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class Passenger extends User {
    private String homeAddress;

    public Passenger() {
        setRole(Role.PASSENGER);
    }
}

