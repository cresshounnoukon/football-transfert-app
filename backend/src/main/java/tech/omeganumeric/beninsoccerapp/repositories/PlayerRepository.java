package tech.omeganumeric.beninsoccerapp.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import tech.omeganumeric.beninsoccerapp.models.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    // Add custom queries if needed
}