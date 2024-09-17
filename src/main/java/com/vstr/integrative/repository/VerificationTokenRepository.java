package com.vstr.integrative.repository;

import com.vstr.integrative.model.VerifyToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerifyToken, Long> {

    VerifyToken findByUserEmailAndToken(String email, String token);

    VerifyToken findByUserEmail(String email);
}
