package com.example.clientsservice.repositories;

import com.example.clientsservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
    boolean existsByLogin(String login);
}
