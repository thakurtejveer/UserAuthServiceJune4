package com.scaler.userauthservicejune4.repo;

import com.scaler.userauthservicejune4.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    public Optional<User> findByEmailEquals(String email);
}
