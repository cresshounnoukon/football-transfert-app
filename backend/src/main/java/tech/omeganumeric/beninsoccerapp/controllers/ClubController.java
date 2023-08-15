package tech.omeganumeric.beninsoccerapp.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import tech.omeganumeric.beninsoccerapp.models.Club;
import tech.omeganumeric.beninsoccerapp.models.Country;
import tech.omeganumeric.beninsoccerapp.payloads.requests.ClubPayload;
import tech.omeganumeric.beninsoccerapp.payloads.responses.ClubResponsePayload;
import tech.omeganumeric.beninsoccerapp.services.ClubService;

import java.util.List;

@RestController
@RequestMapping("/clubs")
public class ClubController {
    private final ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping
    public Page<ClubResponsePayload> readAll(Pageable pageable) {
        return clubService.readAll(pageable);
    }

    @GetMapping("/{id}")
    public ClubResponsePayload readById(@PathVariable Long id) {
        return clubService.readById(id);
    }

    @PostMapping
    public ClubResponsePayload save(@RequestBody @Valid ClubPayload payload) {
        return clubService.save(payload);
    }

    @PutMapping("/{id}")
    public ClubResponsePayload update(@PathVariable Long id,
                                      @RequestBody @Valid ClubPayload payload) {
        return clubService.update(id, payload);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clubService.delete(id);

    }
}
