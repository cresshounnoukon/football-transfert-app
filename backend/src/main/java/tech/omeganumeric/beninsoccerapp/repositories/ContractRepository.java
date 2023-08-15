package tech.omeganumeric.beninsoccerapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.omeganumeric.beninsoccerapp.models.Contract;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    // Add custom queries if needed
}
