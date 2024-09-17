package com.vstr.integrative.service;

import com.vstr.integrative.model.User;

import java.time.LocalDateTime;

public interface VerificationService {

    void createVerificationToken(User user, String token, LocalDateTime expiryDate);

    boolean verifyVerificationToken(String email, String token);

    void verifyEmail(String email);

    boolean isEmailVerified(String email);
}
