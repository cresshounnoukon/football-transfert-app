package tech.omeganumeric.beninsoccerapp.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;
import tech.omeganumeric.beninsoccerapp.payloads.requests.TransferOfferPayload;
import tech.omeganumeric.beninsoccerapp.payloads.responses.TransferOfferResponsePayload;
import tech.omeganumeric.beninsoccerapp.services.TransferOfferService;

@RestController
@RequestMapping("/transfer-offers")
public class TransferOfferController {
    private final TransferOfferService transferOfferService;

    @Autowired
    public TransferOfferController(TransferOfferService transferOfferService) {
        this.transferOfferService = transferOfferService;
    }

    @GetMapping
    public Page<TransferOfferResponsePayload> readAll(Pageable pageable) {
        return transferOfferService.readAll(pageable);
    }

    @GetMapping("/{id}")
    public TransferOfferResponsePayload readById(@PathVariable Long id) {
        return transferOfferService.readById(id);
    }

    @PostMapping
    public TransferOfferResponsePayload save(@RequestBody @Valid TransferOfferPayload payload) {
        return transferOfferService.save(payload);
    }

    @PutMapping("/{id}")
    public TransferOfferResponsePayload update(@PathVariable Long id,
                                               @RequestBody @Valid TransferOfferPayload payload) {
        return transferOfferService.update(id, payload);
    }

    @DeleteMapping("/{id}")
    public void  delete(@PathVariable Long id) {
        transferOfferService.delete(id);

    }
}
