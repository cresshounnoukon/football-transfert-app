package tech.omeganumeric.beninsoccerapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.omeganumeric.beninsoccerapp.exceptions.ResourceNotFoundException;
import tech.omeganumeric.beninsoccerapp.models.Player;
import tech.omeganumeric.beninsoccerapp.repositories.PlayerRepository;

import java.util.List;


@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Page<Player> readAll(Pageable pageable) {
        return playerRepository.findAll(pageable);
    }

    public Player readById(Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found with id: " + id));
    }

    public Player save(Player player) {
        return playerRepository.save(player);
    }

    public Player update(Player player) {
        if (!playerRepository.existsById(player.getId())) {
            throw new ResourceNotFoundException("Player not found with id: " + player.getId());
        }
        return playerRepository.save(player);
    }

    public void delete(Long id) {
        playerRepository.deleteById(id);
    }
}
