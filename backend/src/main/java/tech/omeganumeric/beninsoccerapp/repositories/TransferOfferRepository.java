package tech.omeganumeric.beninsoccerapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.omeganumeric.beninsoccerapp.models.TransferOffer;

public interface TransferOfferRepository extends JpaRepository<TransferOffer, Long> {
    // Add any custom query methods if needed
}
