package com.pranshu.signup.repository;

import com.pranshu.signup.model.ResetToken;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResetTokenRepository extends MongoRepository<ResetToken, String> {
    Optional<ResetToken> findByToken(String token);
}
