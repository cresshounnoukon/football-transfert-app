package tech.omeganumeric.beninsoccerapp.payloads.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClubPayload {
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "City is required")
    private String city;

    private int yearOfEstablishment;

    // Other payload fields with validation rules
}
