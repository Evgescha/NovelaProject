package com.novelasgame.novelas.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.novelasgame.novelas.repository.DropEntity;

import lombok.Data;

@Data
@Table
@Entity
public class Game extends AbstractEntity implements DropEntity{
    
    @Column(unique = true)
    private String name;
    
    @Column
    private String originalName;
    
    @Column
    private String avatar="default.png";

    @Column(length=1000)
    private String description;
    
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "game_label", joinColumns = { @JoinColumn(name = "gameID") }, inverseJoinColumns = {
            @JoinColumn(name = "labelID") })
    private List<Label> labels;
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy="game", cascade=CascadeType.ALL)
    private Collection<ResourceItem> resourceItems;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String getOwnerUsername() {
        return user.getUsername();
    }

    @Override
    public String toString() {
        return "Game [name=" + name + ", originalName=" + originalName + ", avatar=" + avatar + ", description="
                + description + ", labels=" + labels + "]";
    }
    

}
