package com.shopme.admin.service;

import com.shopme.shopmecommon.model.Role;
import com.shopme.shopmecommon.model.User;

import java.util.List;

public interface IUserService {
    List<User> listAll();
    List<Role> getAllRoles();
    void saveUser(User user);
}
