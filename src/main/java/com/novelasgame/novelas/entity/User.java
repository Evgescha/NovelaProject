package com.novelasgame.novelas.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table
@Data
public class User extends AbstractEntity{
    
    @Column
    private String login;
    
    @Column
    private String email;
    
    @Column
    @JsonIgnore
    private String password;
    
    @Column
    private String avatar="default.png";
    
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
//    @Fetch(value = FetchMode.SUBSELECT)
//    private Collection<UserGame> userGames;
    
    @ManyToMany(cascade = {CascadeType.ALL})
    @JsonIgnore
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(
            name="user_role",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name ="role_id")
            )
    private Collection<Role> roles = new ArrayList<Role>();

    public User(String login) {
        super();
        this.login = login;
    }

    public User() {
        super();
    }
    
    
    
    
}
