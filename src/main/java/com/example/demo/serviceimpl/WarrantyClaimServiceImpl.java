package com.example.demo.serviceimpl;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.repository.WarrantyClaimRecordRepository;
import com.example.demo.service.WarrantyClaimService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarrantyClaimServiceImpl implements WarrantyClaimService {

    private final WarrantyClaimRecordRepository repository;

    public WarrantyClaimServiceImpl(WarrantyClaimRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public WarrantyClaimRecord getClaimById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<WarrantyClaimRecord> getAllClaims() {
        return repository.findAll();
    }

    @Override
    public List<WarrantyClaimRecord> getClaimsBySerial(String serialNumber) {
        return repository.findBySerialNumber(serialNumber);
    }

    @Override
    public WarrantyClaimRecord updateClaimStatus(Long id, String status) {
        Optional<WarrantyClaimRecord> optional = repository.findById(id);
        if (optional.isPresent()) {
            WarrantyClaimRecord record = optional.get();
            record.setStatus(status);
            return repository.save(record);
        }
        return null;
    }

    @Override
    public WarrantyClaimRecord saveClaim(WarrantyClaimRecord record) {
        return repository.save(record);
    }
}
