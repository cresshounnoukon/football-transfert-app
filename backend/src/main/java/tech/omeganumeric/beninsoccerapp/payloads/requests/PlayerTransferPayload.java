package tech.omeganumeric.beninsoccerapp.payloads.requests;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PlayerTransferPayload {
    @NotNull(message = "From club ID is required")
    private Long fromClubId;

    @NotNull(message = "To club ID is required")
    private Long toClubId;

    @NotNull(message = "Player ID is required")
    private Long playerId;

    @DecimalMin(value = "0.0", message = "Transfer fee must be non-negative")
    private BigDecimal transferFee;

    // Other payload fields with validation rules
}
