package com.estoque.livraria.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.estoque.livraria.service.DataBaseService;

@Configuration
@Profile("dev")
public class ProfileDevConfig {

	/**
	 * Se for perfil de teste rodar base MySQL application.properties
	 * 
	 **/

	@Autowired
	private DataBaseService dataBaseService;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;

	@Bean
	public boolean startDatabaseDev() {

		if (strategy.equals("create")) {
			dataBaseService.startDB();
		}

		return false;
	}
}