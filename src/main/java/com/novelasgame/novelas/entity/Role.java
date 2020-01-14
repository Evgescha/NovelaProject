package com.novelasgame.novelas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Role extends AbstractEntity{

    @Column
    private String name;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    
    public Role(String name) {
        super();
        this.name = name;
    }
    
    public Role(String name, User user) {
        super();
        this.name = name;
        this.user = user;
    }
    
    public Role() {}
    
}
