package com.novelasgame.novelas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.novelasgame.novelas.entity.Role;
import com.novelasgame.novelas.entity.User;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    Role findByNameIgnoreCase(String login);  
}
