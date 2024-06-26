package com.hirehub.user.microservice.alluser;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {
    public Optional<User> findByEmailId(String username);
}
