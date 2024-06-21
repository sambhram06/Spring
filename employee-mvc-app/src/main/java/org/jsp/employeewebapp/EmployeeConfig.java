package org.jsp.employeewebapp;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"org.jsp.employeewebapp"})
public class EmployeeConfig {

	@Bean
	public EntityManager entityManager() {
		return Persistence.createEntityManagerFactory("dev").createEntityManager();
	}
}
