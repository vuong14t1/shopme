package com.shopme.admin.model;

import com.shopme.admin.ShopmeBackendApplication;
import com.shopme.admin.repository.RoleRepository;
import com.shopme.shopmecommon.model.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest(classes = ShopmeBackendApplication.class)
public class RoleTest {
    @Autowired
    private RoleRepository repository;

    @BeforeEach
    public void beforeEach(){
        System.out.println("enter before each");
    }

    @Test
    public void createRolesTest(){
        Role role1 = new Role("Admin", "Manage everything");
        Role role2 = new Role("Salesperson", "Manage product price, customers, shipping, orders and sales report");
        Role role3 = new Role("Editor", "Manage categories, brands, products, articles and menus");
        Role role4 = new Role("Shipper", "View products, orders, and update order status");
        Role role5 = new Role("Assistant", "manage questions and reviews");
        repository.saveAll(Arrays.asList(role1, role2, role3, role4, role5));
        assertThat(repository.findAll().size()).isEqualTo(5);
    }
}
