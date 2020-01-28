package com.novelasgame.novelas.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table
@Data
public class User extends AbstractEntity {

    @Column
    @NotNull
    private String username;

    @Column
    @NotNull
    private String email;

    @Column
    @JsonIgnore
    @NotNull
    private String password;

    @Column
    private String avatar = "default.png";

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private Collection<UserGame> userGames;

    @JsonIgnore
    @Fetch(value = FetchMode.SELECT)
    @ManyToMany(cascade = { CascadeType.PERSIST }, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"),
        uniqueConstraints = @UniqueConstraint(
                name="users_roles",
                columnNames = {"user_id", "role_id"})
    )
    private Collection<Role> roles;

    public User(String username) {
        super();
        this.username = username;
    }

    public User() {
        super();
    }
    
    public List<String> getRoleListNames() {
        List<String> roleNames = new ArrayList<>();
        for (Role currRole : getRoles()) {
            roleNames.add(currRole.getName());
        }
        return roleNames;
    }

}
