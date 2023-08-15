package tech.omeganumeric.beninsoccerapp.payloads.requests;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferOfferPayload {
    @NotNull(message = "Player transfer ID is required")
    private Long playerTransferId;

    @NotNull(message = "Offering club ID is required")
    private Long offeringClubId;

    @DecimalMin(value = "0.0", message = "Proposed price must be non-negative")
    private BigDecimal proposedPrice;

    // Other payload fields with validation rules
}
