package com.novelasgame.novelas.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.novelasgame.novelas.entity.Game;
import com.novelasgame.novelas.entity.ResourceItem;

@Repository
public interface ResourcesItemRepository extends JpaRepository<ResourceItem, Long> {
    public ResourceItem findByType(String type);

    public ResourceItem findByGame(Game game);
    
    @Query(value = "SELECT ri FROM ResourceItem ri where ri.game_id = :gameId")
    public Collection<ResourceItem> findByGameId(@Param("gameId") String gameId);
    
    @Query(value = "SELECT ri FROM ResourceItem ri where ri.game.name = :gameName")
    public Collection<ResourceItem> findByGameName(@Param("gameName") String gameName);
}
