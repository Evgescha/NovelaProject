package com.novelasgame.novelas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.novelasgame.novelas.entity.Label;

@Repository
public interface LabelRepository extends JpaRepository<Label, Long> {

}
