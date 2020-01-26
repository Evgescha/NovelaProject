package com.novelasgame.novelas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.novelasgame.novelas.entity.UserGame;

public interface UserGameRepository extends JpaRepository<UserGame, Long>{

}
