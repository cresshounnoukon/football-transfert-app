package tech.omeganumeric.beninsoccerapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.omeganumeric.beninsoccerapp.exceptions.BadRequestException;
import tech.omeganumeric.beninsoccerapp.exceptions.ResourceNotFoundException;
import tech.omeganumeric.beninsoccerapp.models.Club;
import tech.omeganumeric.beninsoccerapp.payloads.requests.ClubPayload;
import tech.omeganumeric.beninsoccerapp.payloads.responses.ClubResponsePayload;
import tech.omeganumeric.beninsoccerapp.repositories.ClubRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
@Transactional
public class ClubService {
    private final ClubRepository clubRepository;

    @Autowired
    public ClubService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    public Page<ClubResponsePayload> readAll(Pageable pageable) {
        Page<Club> clubs = clubRepository.findAll(pageable);
        return clubs.map(this::mapToResponsePayload);
    }

    public ClubResponsePayload readById(Long id) {
        Club club = getClubById(id);
        return mapToResponsePayload(club);
    }

    public ClubResponsePayload save(ClubPayload payload) {
        Club club = new Club();
        club.setName(payload.getName());
        club.setCity(payload.getCity());
        club.setYearOfEstablishment(payload.getYearOfEstablishment());

        return mapToResponsePayload(clubRepository.save(club));
    }

    public ClubResponsePayload update(Long id, ClubPayload payload) {
        Club club = getClubById(id);
        club.setName(payload.getName());
        club.setCity(payload.getCity());
        club.setYearOfEstablishment(payload.getYearOfEstablishment());

        return mapToResponsePayload(clubRepository.save(club));
    }

    public void delete(Long id) {
        Club club = getClubById(id);
        clubRepository.delete(club);
    }

    public Club getClubById(Long id) {
        return clubRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Club not found with id: " + id));
    }

    private ClubResponsePayload mapToResponsePayload(Club club) {
        ClubResponsePayload responsePayload = new ClubResponsePayload();
        responsePayload.setId(club.getId());
        responsePayload.setName(club.getName());
        responsePayload.setCity(club.getCity());
        responsePayload.setYearOfEstablishment(club.getYearOfEstablishment());

        return responsePayload;
    }
}
