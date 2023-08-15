package tech.omeganumeric.beninsoccerapp.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import tech.omeganumeric.beninsoccerapp.models.PlayerTransfer;
import tech.omeganumeric.beninsoccerapp.payloads.requests.PlayerTransferPayload;
import tech.omeganumeric.beninsoccerapp.payloads.responses.PlayerTransferResponsePayload;
import tech.omeganumeric.beninsoccerapp.services.PlayerTransferService;
@RestController
@RequestMapping("/player-transfers")
public class PlayerTransferController {
    private final PlayerTransferService playerTransferService;

    @Autowired
    public PlayerTransferController(PlayerTransferService playerTransferService) {
        this.playerTransferService = playerTransferService;
    }

    @GetMapping
    public Page<PlayerTransferResponsePayload> readAll(Pageable pageable) {
        return playerTransferService.readAll(pageable);
    }

    @GetMapping("/{id}")
    public PlayerTransferResponsePayload readById(@PathVariable Long id) {
        return playerTransferService.readById(id);
    }

    @PostMapping
    public PlayerTransferResponsePayload save(@RequestBody @Valid PlayerTransferPayload payload) {
        return playerTransferService.save(payload);
    }

    @PutMapping("/{id}")
    public PlayerTransferResponsePayload update(@PathVariable Long id,
                                                @RequestBody @Valid PlayerTransferPayload payload) {
        return playerTransferService.update(id, payload);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        playerTransferService.delete(id);

    }
}
