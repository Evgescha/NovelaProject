package com.novelasgame.novelas.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table
@Data
public class User {
    
    @Column
    private String login;
    
    @Column
    private String email;
    
    @Column
    @JsonIgnore
    private String password;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    @JsonIgnore
    private Collection<Role> roleList;

    public User(String login) {
        super();
        this.login = login;
    }

    public User() {
        super();
    }
    
    
    
    
}
