package com.shopme.admin.model;

import com.shopme.admin.repository.RoleRepository;
import com.shopme.admin.repository.UserRepository;
import com.shopme.shopmecommon.model.Role;
import com.shopme.shopmecommon.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void createUserWithOneRoleTest(){
        Optional<Role> roleModel = roleRepository.findById(1);
        User user = new User("Vuong14t11@gmail.com", "12345", "Vuong", "Phan Quang");
        user.addRole(roleModel.get());
        user = userRepository.save(user);
        assertThat(user.getId()).isGreaterThan(1);
    }

    @Test
    public void createUserWithTwoRoleTest(){
        User user = new User("vuong2@gmail.com", "12345", "Vuong", "Phan Quang");
        Role role1 = new Role(3);
        Role role2 = new Role(5);
        user.setRoles(new HashSet<>(List.of(role1, role2)));
        user = userRepository.save(user);
        assertThat(user.getEmail()).isEqualTo("vuong2@gmail.com");
        assertThat(user.getRoles().size()).isEqualTo(2);
    }

    @Test
    public void getListUsersTest(){
        List<User> users = userRepository.findAll();
        users.forEach(System.out::println);
        assertThat(users.size()).isGreaterThan(1);
    }

    @Test
    public void getUserByIdTest(){
        int id = 1;
        Optional<User> user = userRepository.findById(id);
        assertThat(user.get().getId()).isEqualTo(id);
    }

    @Test
    public void updateUserDetailTest(){
        int id = 1;
        Optional<User> user = userRepository.findById(id);
        assertThat(user).isNotEmpty();
        user.get().setEmail("vuong1@gmail.com");
        user.get().addRole(new Role(1));
        user.get().addRole(new Role(2));
        User result = userRepository.save(user.get());
        assertThat(result.getRoles().size()).isEqualTo(2);
        assertThat(result.getEmail()).isEqualTo("vuong1@gmail.com");
    }

    @Test
    public void deleteUserByIdTest(){
        int id = 2;
        userRepository.deleteById(id);
        Optional<User> user = userRepository.findById(id);
        assertThat(user).isEmpty();
    }
}
