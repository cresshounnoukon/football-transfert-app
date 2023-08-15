package tech.omeganumeric.beninsoccerapp.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.omeganumeric.beninsoccerapp.exceptions.ResourceNotFoundException;
import tech.omeganumeric.beninsoccerapp.models.Club;
import tech.omeganumeric.beninsoccerapp.models.PlayerTransfer;
import tech.omeganumeric.beninsoccerapp.models.TransferOffer;
import tech.omeganumeric.beninsoccerapp.payloads.requests.TransferOfferPayload;
import tech.omeganumeric.beninsoccerapp.payloads.responses.TransferOfferResponsePayload;
import tech.omeganumeric.beninsoccerapp.repositories.TransferOfferRepository;

@Service
@Transactional
public class TransferOfferService {
    private final TransferOfferRepository transferOfferRepository;
    private final PlayerTransferService playerTransferService;
    private final ClubService clubService;

    @Autowired
    public TransferOfferService(TransferOfferRepository transferOfferRepository,
                                PlayerTransferService playerTransferService,
                                ClubService clubService) {
        this.transferOfferRepository = transferOfferRepository;
        this.playerTransferService = playerTransferService;
        this.clubService = clubService;
    }

    public Page<TransferOfferResponsePayload> readAll(Pageable pageable) {
        Page<TransferOffer> offers = transferOfferRepository.findAll(pageable);
        return offers.map(this::mapToResponsePayload);
    }

    public TransferOfferResponsePayload readById(Long id) {
        TransferOffer offer = getTransferOfferById(id);
        return mapToResponsePayload(offer);
    }

    public TransferOfferResponsePayload save(TransferOfferPayload payload) {
        PlayerTransfer playerTransfer = playerTransferService.getPlayerTransferById(payload.getPlayerTransferId());
        Club offeringClub = clubService.getClubById(payload.getOfferingClubId());

        TransferOffer offer = new TransferOffer();
        offer.setPlayerTransfer(playerTransfer);
        offer.setOfferingClub(offeringClub);
        offer.setProposedPrice(payload.getProposedPrice());

        return mapToResponsePayload(transferOfferRepository.save(offer));
    }

    public TransferOfferResponsePayload update(Long id, TransferOfferPayload payload) {
        TransferOffer offer = getTransferOfferById(id);

        PlayerTransfer playerTransfer = playerTransferService.getPlayerTransferById(payload.getPlayerTransferId());
        Club offeringClub = clubService.getClubById(payload.getOfferingClubId());

        offer.setPlayerTransfer(playerTransfer);
        offer.setOfferingClub(offeringClub);
        offer.setProposedPrice(payload.getProposedPrice());

        return mapToResponsePayload(transferOfferRepository.save(offer));
    }

    public void delete(Long id) {
        TransferOffer offer = getTransferOfferById(id);
        transferOfferRepository.delete(offer);
    }

    private TransferOffer getTransferOfferById(Long id) {
        return transferOfferRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TransferOffer not found with id: " + id));
    }

    private TransferOfferResponsePayload mapToResponsePayload(TransferOffer offer) {
        TransferOfferResponsePayload responsePayload = new TransferOfferResponsePayload();
        responsePayload.setId(offer.getId());
        responsePayload.setPlayerTransferId(offer.getPlayerTransfer().getId());
        responsePayload.setOfferingClubId(offer.getOfferingClub().getId());
        responsePayload.setProposedPrice(offer.getProposedPrice());

        return responsePayload;
    }
}
