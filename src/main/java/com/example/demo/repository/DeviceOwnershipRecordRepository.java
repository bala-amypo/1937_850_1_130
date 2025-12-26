package com.example.demo.repository;

import java.util.*;
import com.example.demo.model.*;

public interface DeviceOwnershipRecordRepository {
    boolean existsBySerialNumber(String serial);
    Optional<DeviceOwnershipRecord> findBySerialNumber(String serial);
    Optional<DeviceOwnershipRecord> findById(Long id);
    List<DeviceOwnershipRecord> findAll();
    DeviceOwnershipRecord save(DeviceOwnershipRecord d);
}
