package com.example.UberAuthService.repositories;

import com.example.UberAuthService.entities.Passenger;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    Boolean existsByEmail(@NotBlank String email);
    Boolean existsByPhoneNumber(@NotBlank String phoneNumber);
}
