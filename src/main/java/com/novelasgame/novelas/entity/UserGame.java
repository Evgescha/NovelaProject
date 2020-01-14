package com.novelasgame.novelas.entity;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class UserGame {

    private String name;
    private Map<String,String> values;
}
