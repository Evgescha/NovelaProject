package com.novelasgame.novelas.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class ResourceCharItem extends ResourceItem {
    private String charName;
}
