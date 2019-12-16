package com.novelasgame.novelas.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Command extends AbstractEntity {

    private String value;

    @ManyToMany(mappedBy = "commands", fetch = FetchType.EAGER)
    private List<Label> labels;

    public Command() {}
    public Command(String str) {this.value=str;}
}
