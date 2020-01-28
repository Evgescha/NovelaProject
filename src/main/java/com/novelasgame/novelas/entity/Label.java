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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table
public class Label extends AbstractEntity {

    @Column(unique = true)
    private String name;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER ,cascade = {CascadeType.ALL})
    private List<Game> games;

    @Fetch(value = FetchMode.SELECT)
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "label_command", joinColumns = { @JoinColumn(name = "labelID") }, inverseJoinColumns = {
            @JoinColumn(name = "commandID") })
    private List<Command> commands;

    @Override
    public String toString() {
        return "Label [name=" + name + "]";
    }

}
