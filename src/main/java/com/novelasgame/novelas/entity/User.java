package com.novelasgame.novelas.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table
@Data
public class User extends AbstractEntity {

    @Column
    private String login;

    @Column
    private String email;

    @Column
    @JsonIgnore
    private String password;

    @Column
    private String avatar = "default.png";

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
//    @Fetch(value = FetchMode.SUBSELECT)
//    private Collection<UserGame> userGames;

    @JsonIgnore
    @Fetch(value = FetchMode.SELECT)
    @ManyToMany(cascade = { CascadeType.PERSIST }, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"),
        uniqueConstraints = @UniqueConstraint(
                name="UK_users_roles",
                columnNames = {"user_id", "role_id"})
    )
    private Collection<Role> roles;

    public User(String login) {
        super();
        this.login = login;
    }

    public User() {
        super();
    }

}
