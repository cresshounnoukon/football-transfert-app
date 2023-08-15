package tech.omeganumeric.beninsoccerapp.payloads.responses;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PlayerTransferResponsePayload {
    private Long id;
    private Long fromClubId;
    private Long toClubId;
    private Long playerId;
    private BigDecimal transferFee;

    // Other payload fields to match response requirements
}
