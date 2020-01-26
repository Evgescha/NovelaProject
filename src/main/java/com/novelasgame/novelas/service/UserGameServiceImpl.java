package com.novelasgame.novelas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novelasgame.novelas.entity.UserGame;
import com.novelasgame.novelas.repository.UserGameRepository;
@Service
public class UserGameServiceImpl implements CrudService<UserGame>{

    @Autowired
    UserGameRepository repository;
    
    @Override
    public boolean create(UserGame entity) {
        try {
            repository.saveAndFlush(entity);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public UserGame read(long id) {
        return repository.findById(id).get();
    }

    @Override
    public boolean update(UserGame entity) {
        try {
            repository.saveAndFlush(entity);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(long id) {
        try {
            repository.deleteById(id);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
