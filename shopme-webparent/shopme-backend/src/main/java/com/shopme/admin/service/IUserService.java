package com.shopme.admin.service;

import com.shopme.shopmecommon.model.Role;
import com.shopme.shopmecommon.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> listAll();
    List<Role> getAllRoles();
    void saveUser(User user);
    boolean isUniqueEmail(Integer id,String email);

    Optional<User> getUserById(int id);
}
