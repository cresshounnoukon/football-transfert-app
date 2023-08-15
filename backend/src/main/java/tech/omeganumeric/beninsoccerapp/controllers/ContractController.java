package tech.omeganumeric.beninsoccerapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import tech.omeganumeric.beninsoccerapp.models.Contract;
import tech.omeganumeric.beninsoccerapp.services.ContractService;

import java.util.List;

@RestController
@RequestMapping("/contracts")
public class ContractController {
    private final ContractService contractService;

    @Autowired
    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping
    public Page<Contract> readAll(Pageable pageable) {
        return contractService.readAll(pageable);
    }

    @GetMapping("/{id}")
    public Contract readById(@PathVariable Long id) {
        return contractService.readById(id);
    }

    @PostMapping
    public Contract save(@RequestBody Contract contract) {
        return contractService.save(contract);
    }

    @PutMapping("/{id}")
    public Contract update(@PathVariable Long id, @RequestBody Contract contract) {
        contract.setId(id);
        return contractService.update(contract);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        contractService.delete(id);
    }
}
