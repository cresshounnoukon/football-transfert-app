package tech.omeganumeric.beninsoccerapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.omeganumeric.beninsoccerapp.models.Country;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Optional<Country> findByName(String name);
    Optional<Country> findByCode(String code);
}