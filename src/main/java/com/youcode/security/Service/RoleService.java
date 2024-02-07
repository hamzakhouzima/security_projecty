package com.youcode.security.Service;

import com.youcode.security.Model.User;

public interface RoleService {
    boolean isAdmin(User user);
    boolean isSuperAdmin(User user);
    boolean isUser(User user);
}
