package tech.omeganumeric.beninsoccerapp.payloads.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CountryPayload {
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Code is required")
    private String code;

    // Other payload fields with validation rules
}

