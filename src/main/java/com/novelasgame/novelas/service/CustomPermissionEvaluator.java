package com.novelasgame.novelas.service;

import java.io.Serializable;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.novelasgame.novelas.repository.DropEntity;

@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        if (authentication == null || !(targetDomainObject instanceof DropEntity) || !(permission instanceof Boolean))
            return false;
        if ((boolean) permission
                || ((DropEntity) targetDomainObject).getOwnerUsername().equals(authentication.getName())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
            Object permission) {
        return false;
    }

}
