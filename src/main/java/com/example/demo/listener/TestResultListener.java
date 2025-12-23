package com.example.demo.listener;

import com.example.demo.model.User;
import com.example.demo.model.WarrantyClaimRecord;

import jakarta.persistence.PrePersist;
import java.time.LocalDateTime;

public class TestResultListener {

    @PrePersist
    public void prePersistWarrantyClaim(WarrantyClaimRecord claim) {
        if (claim.getSubmittedAt() == null) {
            claim.setSubmittedAt(LocalDateTime.now());
        }
    }

    @PrePersist
    public void prePersistUser(User user) {
        if (user.getCreatedAt() == null) {
            user.setCreatedAt(LocalDateTime.now());
        }
    }
}
