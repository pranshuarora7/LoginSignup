package com.pranshu.signup.repository;

import com.pranshu.signup.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByResetToken(String token);
}
