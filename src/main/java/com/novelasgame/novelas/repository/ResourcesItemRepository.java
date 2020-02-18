package com.novelasgame.novelas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.novelasgame.novelas.entity.Game;
import com.novelasgame.novelas.entity.ResourceItem;

@Repository
public interface ResourcesItemRepository extends JpaRepository<ResourceItem, Long> {
    public ResourceItem findByType(String type);

    public ResourceItem findByGame(Game game);
    
}
