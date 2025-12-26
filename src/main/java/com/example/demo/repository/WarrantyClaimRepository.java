package com.example.demo.repository;

import com.example.demo.model.WarrantyClaimRecord;
import java.util.List;
import java.util.Optional;

public interface WarrantyClaimRecordRepository {
    WarrantyClaimRecord save(WarrantyClaimRecord claim);
    Optional<WarrantyClaimRecord> findById(Long id);
    List<WarrantyClaimRecord> findAll();
    List<WarrantyClaimRecord> findBySerialNumber(String serialNumber);
}
