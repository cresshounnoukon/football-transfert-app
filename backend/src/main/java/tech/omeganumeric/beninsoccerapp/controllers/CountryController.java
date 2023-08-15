package tech.omeganumeric.beninsoccerapp.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import tech.omeganumeric.beninsoccerapp.models.Country;
import tech.omeganumeric.beninsoccerapp.payloads.requests.CountryPayload;
import tech.omeganumeric.beninsoccerapp.payloads.responses.CountryResponsePayload;
import tech.omeganumeric.beninsoccerapp.services.CountryService;
@RestController
@RequestMapping("/countries")
public class CountryController {
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public Page<CountryResponsePayload> readAll(Pageable pageable) {
        return countryService.readAll(pageable);
    }

    @GetMapping("/{id}")
    public CountryResponsePayload readById(@PathVariable Long id) {
        return countryService.readById(id);
    }

    @PostMapping
    public CountryResponsePayload save(@RequestBody @Valid CountryPayload payload) {
        return countryService.save(payload);
    }

    @PutMapping("/{id}")
    public CountryResponsePayload update(@PathVariable Long id,
                                         @RequestBody @Valid CountryPayload payload) {
        return countryService.update(id, payload);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        countryService.delete(id);

    }
}
