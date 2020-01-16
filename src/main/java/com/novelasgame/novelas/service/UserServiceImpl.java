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

    public User findByLogin(String login) {
        return repository.findByLoginIgnoreCase(login);
    }

    public boolean userRegistration(User entity) {

        if (repository.findByLoginIgnoreCase(entity.getLogin()) != null
                || repository.findByEmailIgnoreCase(entity.getEmail()) != null)
            return false;

        try {
            if(roleService.findByName(DEFAULT_ROLE)==null)
                roleService.create(new Role(DEFAULT_ROLE));
            
            User user = new User();
            user.setAvatar(entity.getAvatar());
            user.setEmail(entity.getEmail());
            user.setLogin(entity.getLogin());
            user.setPassword(entity.getPassword());
            user.setRoles(Arrays.asList(roleService.findByName(DEFAULT_ROLE)));
//            entity.getRoles().add(new Role(DEFAULT_ROLE));
            create(user);
            user=null;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
