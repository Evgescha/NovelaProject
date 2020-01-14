package com.novelasgame.novelas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novelasgame.novelas.entity.Role;
import com.novelasgame.novelas.entity.User;
import com.novelasgame.novelas.repository.UserRepository;

@Service
public class UserServiceImpl implements CrudService<User> {

    private final static String DEFAULT_ROLE = "ROLE_USER";
    
    @Autowired
    UserRepository repository;

    @Autowired
    RoleServiceImpl roleService;

    @Override
    public boolean create(User entity) {
        try {
            repository.saveAndFlush(entity);
            return true;
        } catch (Exception e) {
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
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(long id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public User findByLogin(String login) {
        return repository.findByLoginIgnoreCase(login);
    }

    public boolean userRegistration(User entity) {

        if (repository.findByLoginIgnoreCase(entity.getLogin()) != null
                || repository.findByEmailIgnoreCase(entity.getEmail()) != null)
            return false;

        try {
            create(entity);
            roleService.create(new Role(DEFAULT_ROLE,entity));            
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
