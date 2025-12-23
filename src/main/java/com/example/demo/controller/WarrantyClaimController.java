package com.example.demo.controller;

import com.example.demo.model.WarrantyClaimRecord;
import com.example.demo.service.WarrantyClaimService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
@Tag(name = "Warranty Claims")
public class WarrantyClaimController {

    private final WarrantyClaimService claimService;

    public WarrantyClaimController(WarrantyClaimService claimService) {
        this.claimService = claimService;
    }

    @PostMapping
    public WarrantyClaimRecord submitClaim(@RequestBody WarrantyClaimRecord claim) {
        return claimService.submitClaim(claim);
    }

    @PutMapping("/{id}/status")
    public void updateStatus(@PathVariable Long id, @RequestParam String status) {
        claimService.updateClaimStatus(id, status);
    }

    @GetMapping("/serial/{serialNumber}")
    public List<WarrantyClaimRecord> getBySerial(@PathVariable String serialNumber) {
        return claimService.getClaimsBySerial(serialNumber);
    }

    @GetMapping("/{id}")
    public WarrantyClaimRecord getById(@PathVariable Long id) {
        return claimService.getClaimById(id);
    }

    @GetMapping
    public List<WarrantyClaimRecord> getAll() {
        return claimService.getAllClaims();
    }
}
