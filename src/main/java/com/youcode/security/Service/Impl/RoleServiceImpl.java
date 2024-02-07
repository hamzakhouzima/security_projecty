package com.youcode.security.Service.Impl;

import com.youcode.security.Model.Roles;
import com.youcode.security.Model.User;
import com.youcode.security.Service.RoleService;

public class RoleServiceImpl implements RoleService {


    @Override
    public boolean isAdmin(User user) {
        return user.hasRole(Roles.ADMIN);

    }

    @Override
    public boolean isSuperAdmin(User user) {
        return user.hasRole(Roles.SUPER_ADMIN);
    }

    @Override
    public boolean isUser(User user) {
        return user.hasRole(Roles.USER);
    }

}
