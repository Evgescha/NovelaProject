package com.novelasgame.novelas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novelasgame.novelas.entity.Game;
import com.novelasgame.novelas.repository.GameRepository;

@Service
public class GameService implements CrudService<Game> {

    @Autowired
    private GameRepository repository;

    @Override
    public boolean create(Game entity) {
        try {
            repository.saveAndFlush(entity);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public Game read(long id) {
        return repository.findById(id).isPresent() ? repository.findById(id).get() : null;
    }

    @Override
    public boolean update(Game entity) {
        try {
            repository.saveAndFlush(entity);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean delete(long id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
