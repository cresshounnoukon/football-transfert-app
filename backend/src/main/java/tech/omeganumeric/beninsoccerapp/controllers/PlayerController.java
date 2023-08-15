package tech.omeganumeric.beninsoccerapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import tech.omeganumeric.beninsoccerapp.models.Player;
import tech.omeganumeric.beninsoccerapp.services.PlayerService;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public Page<Player> readAll(Pageable pageable) {
        return playerService.readAll(pageable);
    }

    @GetMapping("/{id}")
    public Player readById(@PathVariable Long id) {
        return playerService.readById(id);
    }

    @PostMapping
    public Player save(@RequestBody Player player) {
        return playerService.save(player);
    }

    @PutMapping("/{id}")
    public Player update(@PathVariable Long id, @RequestBody Player player) {
        player.setId(id);
        return playerService.update(player);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        playerService.delete(id);
    }
}
