package com.novelasgame.novelas.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table
@Entity
public class Game extends AbstractEntity {
    
    @Column(unique = true)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "game_label", joinColumns = { @JoinColumn(name = "gameID") }, inverseJoinColumns = {
            @JoinColumn(name = "labelID") })
    private List<Label> labels;

}
