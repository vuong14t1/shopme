package com.shopme.admin;

import com.shopme.admin.repository.RoleRepository;
import com.shopme.shopmecommon.model.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ShopmeBackendApplicationTests {

	@Autowired
	private RoleRepository repository;

	@BeforeEach
	public void beforeEach(){
		System.out.println("enter before each");
	}

	@Test
	public void createRoles(){
		Role role = new Role();
		role.setName("Admin");
		role.setDescription("Manage everything");
		Role result = repository.save(role);
		assertThat(result.getId()).isGreaterThan(0);
	}
}
