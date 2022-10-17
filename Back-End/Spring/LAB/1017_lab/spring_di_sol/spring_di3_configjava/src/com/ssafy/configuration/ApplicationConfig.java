package com.ssafy.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
@ComponentScan(basePackages = {"com.ssafy"})
public class ApplicationConfig {

	@Bean
	public DataSource getDataSource() {
		SimpleDriverDataSource sdds = new SimpleDriverDataSource();
		sdds.setDriverClass(com.mysql.cj.jdbc.Driver.class);
		sdds.setUrl("jdbc:mysql://127.0.0.1:3306/ssafyweb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8");
		sdds.setUsername("ssafy");
		sdds.setPassword("ssafy");
		return sdds;
	}
	
}
