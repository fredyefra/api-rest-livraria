package com.estoque.livraria.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.estoque.livraria.service.DataBaseService;

@Configuration
@Profile("test")
public class PofileTestConfig {

	@Autowired
	private DataBaseService dataBaseService;

	//@Bean({"spring.profiles.active=test"})
	@Bean
	public void startDB() {
		dataBaseService.startDB();
	}
}