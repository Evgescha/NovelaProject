package com.novelasgame.novelas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novelasgame.novelas.entity.Role;
import com.novelasgame.novelas.repository.RoleRepository;

@Service
public class RoleServiceImpl implements CrudService<Role>{

    @Autowired
    private RoleRepository repository;
    
    @Override
    public boolean create(Role entity) {
        try {
            repository.saveAndFlush(entity);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public Role read(long id) {
        return repository.findById(id).get();
    }

    @Override
    public boolean update(Role entity) {
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
    public Role findByName(String name) {
        return repository.findByNameIgnoreCase(name);
    }

}
