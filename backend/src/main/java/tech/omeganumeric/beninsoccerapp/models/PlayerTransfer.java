package tech.omeganumeric.beninsoccerapp.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class PlayerTransfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "from_club_id")
    private Club fromClub;

    @ManyToOne
    @JoinColumn(name = "to_club_id")
    private Club toClub;
    private BigDecimal transferPrice;  // Price of the actual transfer
    private BigDecimal proposedPrice;  // Proposed price by the selling club

    private Date transferDate;

    private boolean validated;

    private boolean approved;

    @OneToMany(mappedBy = "playerTransfer", cascade = CascadeType.ALL)
    private List<TransferOffer> transferOffers;


    @OneToOne
    @JoinColumn(name = "selected_offer_id")
    private TransferOffer selectedOffer;  // Reference to the selected offer



}