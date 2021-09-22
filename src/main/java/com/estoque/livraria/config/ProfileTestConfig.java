package com.estoque.livraria.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.estoque.livraria.service.DataBaseService;

@Configuration
@Profile("test")
public class ProfileTestConfig {

	 /**
	 * Se for perfil de teste roda base H2 em memória
	 * 
	 **/

	@Autowired
	private DataBaseService dataBaseService;

	@Bean
	public void startDatabaseTest() {
		dataBaseService.startDB();
	}
}