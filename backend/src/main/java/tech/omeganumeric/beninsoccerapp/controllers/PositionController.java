package tech.omeganumeric.beninsoccerapp.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import tech.omeganumeric.beninsoccerapp.payloads.requests.PositionPayload;
import tech.omeganumeric.beninsoccerapp.payloads.responses.PositionResponsePayload;
import tech.omeganumeric.beninsoccerapp.services.PositionService;

@RestController
@RequestMapping("/positions")
public class PositionController {
    private final PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping
    public Page<PositionResponsePayload> readAll(Pageable pageable) {
        return positionService.readAll(pageable);
    }

    @GetMapping("/{id}")
    public PositionResponsePayload readById(@PathVariable Long id) {
        return positionService.readById(id);
    }

    @PostMapping
    public PositionResponsePayload save(@RequestBody @Valid PositionPayload payload) {
        return positionService.save(payload);
    }

    @PutMapping("/{id}")
    public PositionResponsePayload update(@PathVariable Long id,
                                          @RequestBody @Valid PositionPayload payload) {
        return positionService.update(id, payload);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        positionService.delete(id);

    }
}
