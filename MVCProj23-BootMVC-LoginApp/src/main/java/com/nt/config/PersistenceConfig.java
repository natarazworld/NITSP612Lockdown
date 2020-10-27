package com.nt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

@Configuration
public class PersistenceConfig {
	@Autowired
	private  DataSource ds;
	
	@Bean
	public   SimpleJdbcCall  createSJC() {
		return new SimpleJdbcCall(ds);
	}
	

}
