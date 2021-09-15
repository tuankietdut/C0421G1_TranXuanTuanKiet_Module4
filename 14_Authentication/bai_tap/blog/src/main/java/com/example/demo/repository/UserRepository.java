package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.Stream;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(Stream nameUser);
}
