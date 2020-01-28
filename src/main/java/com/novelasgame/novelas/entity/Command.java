package com.novelasgame.novelas.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table
public class Command extends AbstractEntity {
    @Column(length = 1000)
    private String value;

    @JsonIgnore
    @ManyToMany(mappedBy = "commands", fetch = FetchType.EAGER)
    private List<Label> labels;

    public Command() {}
    public Command(String str) {this.value=str;}
    @Override
    public String toString() {
        return "Command [value=" + value + "]";
    }
    
}
