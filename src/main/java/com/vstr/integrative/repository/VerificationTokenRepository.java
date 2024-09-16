package com.vstr.integrative.repository;

import com.vstr.integrative.model.VerifyToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository extends JpaRepository<VerifyToken, Long> {

    VerifyToken findByEmailAndToken(String email, String token);

    VerifyToken findByEmail(String email);
}
