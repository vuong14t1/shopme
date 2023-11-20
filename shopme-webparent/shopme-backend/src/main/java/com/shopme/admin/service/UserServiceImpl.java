package com.shopme.admin.service;

import com.shopme.admin.repository.UserRepository;
import com.shopme.shopmecommon.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }
}
