package tech.omeganumeric.beninsoccerapp.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class TransferOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_transfer_id")
    private PlayerTransfer playerTransfer;

    @ManyToOne
    @JoinColumn(name = "offering_club_id")
    private Club offeringClub;

    private BigDecimal proposedPrice;

    // Other properties, getters, setters, and methods
}
