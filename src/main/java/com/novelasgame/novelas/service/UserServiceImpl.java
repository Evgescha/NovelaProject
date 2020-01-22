package com.novelasgame.novelas.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novelasgame.novelas.entity.Role;
import com.novelasgame.novelas.entity.User;
import com.novelasgame.novelas.repository.UserRepository;

@Service
public class UserServiceImpl implements CrudService<User> {

    private final static String DEFAULT_ROLE = "ROLE_USER";
    
    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleServiceImpl roleService;

    @Override
    public boolean create(User entity) {
        try {
            repository.saveAndFlush(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
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
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(long id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public User findByUsername(String username) {
        return repository.findByUsernameIgnoreCase(username);
    }

    public boolean userRegistration(User entity) {

        if (repository.findByUsernameIgnoreCase(entity.getUsername()) != null
                || repository.findByEmailIgnoreCase(entity.getEmail()) != null)
            return false;

        try {
            if(roleService.findByName(DEFAULT_ROLE)==null)
                roleService.create(new Role(DEFAULT_ROLE));
            create(entity);
            entity.setRoles(Arrays.asList(roleService.findByName(DEFAULT_ROLE)));
            update(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
