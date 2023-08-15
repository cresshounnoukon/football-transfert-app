package tech.omeganumeric.beninsoccerapp.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.omeganumeric.beninsoccerapp.exceptions.BadRequestException;
import tech.omeganumeric.beninsoccerapp.exceptions.ResourceNotFoundException;
import tech.omeganumeric.beninsoccerapp.models.Club;
import tech.omeganumeric.beninsoccerapp.models.Player;
import tech.omeganumeric.beninsoccerapp.models.PlayerTransfer;
import tech.omeganumeric.beninsoccerapp.models.TransferOffer;
import tech.omeganumeric.beninsoccerapp.payloads.requests.PlayerTransferPayload;
import tech.omeganumeric.beninsoccerapp.payloads.responses.PlayerTransferResponsePayload;
import tech.omeganumeric.beninsoccerapp.repositories.PlayerTransferRepository;

import java.util.List;
@Service
@Transactional
public class PlayerTransferService {
    private final PlayerTransferRepository playerTransferRepository;
    private final ClubService clubService;
    private final PlayerService playerService;

    @Autowired
    public PlayerTransferService(PlayerTransferRepository playerTransferRepository,
                                 ClubService clubService,
                                 PlayerService playerService) {
        this.playerTransferRepository = playerTransferRepository;
        this.clubService = clubService;
        this.playerService = playerService;
    }

    public Page<PlayerTransferResponsePayload> readAll(Pageable pageable) {
        Page<PlayerTransfer> transfers = playerTransferRepository.findAll(pageable);
        return transfers.map(this::mapToResponsePayload);
    }

    public PlayerTransferResponsePayload readById(Long id) {
        PlayerTransfer transfer = getPlayerTransferById(id);
        return mapToResponsePayload(transfer);
    }

    public PlayerTransferResponsePayload save(PlayerTransferPayload payload) {
        Club fromClub = clubService.getClubById(payload.getFromClubId());
        Club toClub = clubService.getClubById(payload.getToClubId());
        Player player = playerService.readById(payload.getPlayerId());

        PlayerTransfer transfer = new PlayerTransfer();
        transfer.setFromClub(fromClub);
        transfer.setToClub(toClub);
        transfer.setPlayer(player);
        transfer.setTransferPrice(payload.getTransferFee());

        return mapToResponsePayload(playerTransferRepository.save(transfer));
    }

    public PlayerTransferResponsePayload update(Long id, PlayerTransferPayload payload) {
        PlayerTransfer transfer = getPlayerTransferById(id);

        Club fromClub = clubService.getClubById(payload.getFromClubId());
        Club toClub = clubService.getClubById(payload.getToClubId());
        Player player = playerService.readById(payload.getPlayerId());

        transfer.setFromClub(fromClub);
        transfer.setToClub(toClub);
        transfer.setPlayer(player);
        transfer.setTransferPrice(payload.getTransferFee());

        return mapToResponsePayload(playerTransferRepository.save(transfer));
    }

    public void delete(Long id) {
        PlayerTransfer transfer = getPlayerTransferById(id);
        playerTransferRepository.delete(transfer);
    }

    public PlayerTransfer getPlayerTransferById(Long id) {
        return playerTransferRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PlayerTransfer not found with id: " + id));
    }

    private PlayerTransferResponsePayload mapToResponsePayload(PlayerTransfer transfer) {
        PlayerTransferResponsePayload responsePayload = new PlayerTransferResponsePayload();
        responsePayload.setId(transfer.getId());
        responsePayload.setFromClubId(transfer.getFromClub().getId());
        responsePayload.setToClubId(transfer.getToClub().getId());
        responsePayload.setPlayerId(transfer.getPlayer().getId());
        responsePayload.setTransferFee(transfer.getTransferPrice());

        return responsePayload;
    }
}
