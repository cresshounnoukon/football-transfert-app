package tech.omeganumeric.beninsoccerapp.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.omeganumeric.beninsoccerapp.exceptions.ResourceNotFoundException;
import tech.omeganumeric.beninsoccerapp.models.Country;
import tech.omeganumeric.beninsoccerapp.payloads.requests.CountryPayload;
import tech.omeganumeric.beninsoccerapp.payloads.responses.CountryResponsePayload;
import tech.omeganumeric.beninsoccerapp.repositories.CountryRepository;

import java.util.Optional;
@Service
@Transactional
public class CountryService {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Page<CountryResponsePayload> readAll( Pageable pageable) {

        Page<Country> countries = countryRepository.findAll(pageable);
        return countries.map(this::mapToResponsePayload);
    }

    public CountryResponsePayload readById(Long id) {
        Country country = getCountryById(id);
        return mapToResponsePayload(country);
    }

    public CountryResponsePayload save(CountryPayload payload) {
        Country country = new Country();
        country.setName(payload.getName());
        country.setCode(payload.getCode());

        return mapToResponsePayload(countryRepository.save(country));
    }

    public CountryResponsePayload update(Long id, CountryPayload payload) {
        Country country = getCountryById(id);
        country.setName(payload.getName());
        country.setCode(payload.getCode());

        return mapToResponsePayload(countryRepository.save(country));
    }

    public void delete(Long id) {
        Country country = getCountryById(id);
        countryRepository.delete(country);
    }

    private Country getCountryById(Long id) {
        return countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country not found with id: " + id));
    }

    private CountryResponsePayload mapToResponsePayload(Country country) {
        CountryResponsePayload responsePayload = new CountryResponsePayload();
        responsePayload.setId(country.getId());
        responsePayload.setName(country.getName());
        responsePayload.setCode(country.getCode());

        return responsePayload;
    }
}
