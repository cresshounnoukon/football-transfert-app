package tech.omeganumeric.beninsoccerapp.payloads.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PositionPayload {
    @NotBlank(message = "Name is required")
    private String name;

    // Other payload fields with validation rules
}
