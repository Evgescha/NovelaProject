package com.novelasgame.novelas.entity;


import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class UserGame extends AbstractEntity{
    @Column
    private String name;
    
    @ElementCollection
    @Column
    private Map<String,String> keyVal;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    
}
