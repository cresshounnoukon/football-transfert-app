package tech.omeganumeric.beninsoccerapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.omeganumeric.beninsoccerapp.models.PlayerTransfer;

public interface PlayerTransferRepository extends JpaRepository<PlayerTransfer, Long> {
    // Add custom queries if needed
}
