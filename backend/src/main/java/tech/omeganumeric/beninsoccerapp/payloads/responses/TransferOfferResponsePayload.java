package tech.omeganumeric.beninsoccerapp.payloads.responses;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferOfferResponsePayload {
    private Long id;
    private Long playerTransferId;
    private Long offeringClubId;
    private BigDecimal proposedPrice;

    // Other payload fields to match response requirements
}
