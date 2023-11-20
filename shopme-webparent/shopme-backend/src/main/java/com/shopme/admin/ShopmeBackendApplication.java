package com.shopme.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@EntityScan({"com.shopme.shopmecommon"})
public class ShopmeBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopmeBackendApplication.class, args);
	}

}
