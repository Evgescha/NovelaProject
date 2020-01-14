package com.novelasgame.novelas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novelasgame.novelas.entity.User;
import com.novelasgame.novelas.repository.UserRepository;

@Service
public class UserServiceImpl implements CrudService<User>{

    @Autowired
    UserRepository repository;
    

    @Override
    public boolean create(User entity) {
        try {
            repository.saveAndFlush(entity);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public User read(long id) {
        return repository.findById(id).get();
    }

    @Override
    public boolean update(User entity) {
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
 
    public User findByLogin(String login) {
        return repository.findByLoginIgnoreCase(login);
    }
}
