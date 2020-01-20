package com.novelasgame.novelas.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Role extends AbstractEntity {

    @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    private Collection<User> users = new ArrayList<User>();

    public Role(final String name) {
        super();
        this.name = name;
    }

    public Role(final String name, final Collection<User> users) {
        super();
        this.name = name;
        this.users = users;
    }

    public Role() {
        super();
    }
}
