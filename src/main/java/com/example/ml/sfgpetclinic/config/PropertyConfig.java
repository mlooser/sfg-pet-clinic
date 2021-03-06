package com.example.ml.sfgpetclinic.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:datasource.properties")
public class PropertyConfig {

	@Value("${clinic.db.username}")
	private String user;
	
	@Value("${clinic.db.password}")
	private String password;
	
	@Value("${clinic.db.url}")
	private String dburl;
		
	
	@Bean
	public PetClinicDataSource petClinicDataSource() {
		PetClinicDataSource dataSource = new PetClinicDataSource();
		
		dataSource.setUser(user);
		dataSource.setPassword(password);
		dataSource.setDburl(dburl);
		
		return dataSource;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer prop = new PropertySourcesPlaceholderConfigurer();
		return prop;
	}
}
