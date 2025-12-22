package com.example.demo.serviceimpl;

import com.example.demo.model.DeviceOwnershipRecord;
import com.example.demo.repository.DeviceOwnershipRecordRepository;
import com.example.demo.service.DeviceOwnershipService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceOwnershipServiceImpl implements DeviceOwnershipService {

    private final DeviceOwnershipRecordRepository repository;

    public DeviceOwnershipServiceImpl(DeviceOwnershipRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeviceOwnershipRecord create(DeviceOwnershipRecord record) {
        return repository.save(record);
    }

    @Override
    public DeviceOwnershipRecord update(Long id, DeviceOwnershipRecord record) {
        record.setId(id);
        return repository.save(record);
    }

    @Override
    public Optional<DeviceOwnershipRecord> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<DeviceOwnershipRecord> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
