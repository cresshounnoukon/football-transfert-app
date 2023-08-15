package tech.omeganumeric.beninsoccerapp.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.omeganumeric.beninsoccerapp.exceptions.ResourceNotFoundException;
import tech.omeganumeric.beninsoccerapp.models.Position;
import tech.omeganumeric.beninsoccerapp.payloads.requests.PositionPayload;
import tech.omeganumeric.beninsoccerapp.payloads.responses.PositionResponsePayload;
import tech.omeganumeric.beninsoccerapp.repositories.PositionRepository;

@Service
@Transactional
public class PositionService {
    private final PositionRepository positionRepository;

    @Autowired
    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public Page<PositionResponsePayload> readAll(Pageable pageable) {
        Page<Position> positions = positionRepository.findAll(pageable);
        return positions.map(this::mapToResponsePayload);
    }

    public PositionResponsePayload readById(Long id) {
        Position position = getPositionById(id);
        return mapToResponsePayload(position);
    }

    public PositionResponsePayload save(PositionPayload payload) {
        Position position = new Position();
        position.setName(payload.getName());

        return mapToResponsePayload(positionRepository.save(position));
    }

    public PositionResponsePayload update(Long id, PositionPayload payload) {
        Position position = getPositionById(id);
        position.setName(payload.getName());

        return mapToResponsePayload(positionRepository.save(position));
    }

    public void delete(Long id) {
        Position position = getPositionById(id);
        positionRepository.delete(position);
    }

    private Position getPositionById(Long id) {
        return positionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Position not found with id: " + id));
    }

    private PositionResponsePayload mapToResponsePayload(Position position) {
        PositionResponsePayload responsePayload = new PositionResponsePayload();
        responsePayload.setId(position.getId());
        responsePayload.setName(position.getName());

        return responsePayload;
    }
}
