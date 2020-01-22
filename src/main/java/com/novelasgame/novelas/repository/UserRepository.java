package com.novelasgame.novelas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.novelasgame.novelas.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    User findByUsernameIgnoreCase(String username);  
    User findByEmailIgnoreCase(String email);  
}
