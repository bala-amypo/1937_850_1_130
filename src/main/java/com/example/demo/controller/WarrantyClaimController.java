package com.example.demo.controller;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.service.impl.WarrantyClaimServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/claims")
public class WarrantyClaimController {

    private final WarrantyClaimServiceImpl claimService;

    public WarrantyClaimController(WarrantyClaimServiceImpl claimService) {
        this.claimService = claimService;
    }

    @PostMapping("/submit")
    public WarrantyClaimRecord submitClaim(@RequestBody WarrantyClaimRecord claim) {
        return claimService.submitClaim(claim);
    }

    @GetMapping("/{id}")
    public Optional<WarrantyClaimRecord> getClaimById(@PathVariable Long id) {
        return claimService.getClaimById(id);
    }

    @GetMapping
    public List<WarrantyClaimRecord> getAllClaims() {
        return claimService.getAllClaims();
    }

    @PutMapping("/{id}/status")
    public WarrantyClaimRecord updateClaimStatus(@PathVariable Long id, @RequestParam String status) {
        return claimService.updateClaimStatus(id, status);
    }

    @GetMapping("/by-serial/{serial}")
    public List<WarrantyClaimRecord> getClaimsBySerial(@PathVariable String serial) {
        return claimService.getClaimsBySerial(serial);
    }
}
