package com.produtos.apirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;



@SpringBootApplication
@EnableJdbcHttpSession
// @EnableCaching
@OpenAPIDefinition(info= @Info(title = "CAAT API",version = "1.0",description = "It's CAAT API documentation..."))
public class ApirestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApirestApplication.class, args);
	}

}
