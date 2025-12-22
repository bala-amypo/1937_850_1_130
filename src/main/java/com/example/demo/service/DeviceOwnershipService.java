package com.example.demo.service;

import com.example.demo.model.DeviceOwnershipRecord;
import java.util.List;
import java.util.Optional;

public interface DeviceOwnershipService {

    DeviceOwnershipRecord create(DeviceOwnershipRecord record);

    DeviceOwnershipRecord update(Long id, DeviceOwnershipRecord record);

    Optional<DeviceOwnershipRecord> getById(Long id);

    List<DeviceOwnershipRecord> getAll();

    void delete(Long id);
}
