package com.novelasgame.novelas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.novelasgame.novelas.entity.User;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserServiceImpl userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> grantList = null;
        User user = userService.findByLogin(username);
        org.springframework.security.core.userdetails.User userDetails = null;
        if (user == null)
            throw new UsernameNotFoundException("User " + username + " was not found in the database");

        if (user.getRoleListNames() != null) {
            grantList = new ArrayList<GrantedAuthority>();
            for (String role : user.getRoleListNames()) {
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
            userDetails = new org.springframework.security.core.userdetails.User(user.getLogin(), 
                    user.getPassword(), grantList);
        }
        return userDetails;
    }

}
