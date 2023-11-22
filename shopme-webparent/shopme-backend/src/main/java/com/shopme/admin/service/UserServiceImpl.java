package com.shopme.admin.service;

import com.shopme.admin.exception.NotFoundUserException;
import com.shopme.admin.repository.RoleRepository;
import com.shopme.admin.repository.UserRepository;
import com.shopme.shopmecommon.model.Role;
import com.shopme.shopmecommon.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        if(user.getId() == null){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }else{
            if(user.getPassword() != null){
                user.setPassword(passwordEncoder.encode(user.getPassword()));
            }else{
                User existUser = userRepository.findById(user.getId()).get();
                user.setPassword(existUser.getPassword());
            }
        }
        userRepository.save(user);
    }

    @Override
    public boolean isUniqueEmail(Integer id, String email) {
        User user = userRepository.findUserByEmail(email);
        if(id != null) {
            Optional<User> existedUser = userRepository.findById(id);
            if(!existedUser.get().getEmail().equals(email)){
                return user == null;
            }
            return true;
        }

        return  user == null;
    }

    @Override
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }
}
