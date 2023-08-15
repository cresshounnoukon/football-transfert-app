package tech.omeganumeric.beninsoccerapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.omeganumeric.beninsoccerapp.models.Club;

public interface ClubRepository extends JpaRepository<Club, Long> {
    // Add custom queries if needed
}