package com.novelasgame.novelas.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Table
@Entity
public class Game extends AbstractEntity {
    
    @Column(unique = true)
    private String name;
    
    @Column
    private String originalName;
    
    @Column
    private String avatar="default.png";

    @Column(length=1000)
    private String description;
    
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "game_label", joinColumns = { @JoinColumn(name = "gameID") }, inverseJoinColumns = {
            @JoinColumn(name = "labelID") })
    private List<Label> labels;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
