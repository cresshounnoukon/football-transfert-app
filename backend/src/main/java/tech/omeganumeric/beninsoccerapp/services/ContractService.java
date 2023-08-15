package tech.omeganumeric.beninsoccerapp.services;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.omeganumeric.beninsoccerapp.exceptions.ResourceNotFoundException;
import tech.omeganumeric.beninsoccerapp.models.Contract;
import tech.omeganumeric.beninsoccerapp.repositories.ContractRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContractService {
    private final ContractRepository contractRepository;

    @Autowired
    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public Page<Contract> readAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    public Contract readById(Long id) {
        return contractRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contract not found with id: " + id));
    }

    public Contract save(Contract contract) {
        return contractRepository.save(contract);
    }

    public Contract update(Contract contract) {
        if (!contractRepository.existsById(contract.getId())) {
            throw new ResourceNotFoundException("Contract not found with id: " + contract.getId());
        }
        return contractRepository.save(contract);
    }

    public void delete(Long id) {
        try {
            contractRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new ResourceNotFoundException("Contract not found with id: " + id);
        } catch (DataAccessException ex) {
            throw new ResourceNotFoundException("Error occurred while deleting contract: " + ex.getMessage());
        }
    }
}
