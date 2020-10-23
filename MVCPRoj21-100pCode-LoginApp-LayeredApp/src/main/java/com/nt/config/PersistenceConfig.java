package com.nt.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
public class PersistenceConfig {
	
	@Bean
	public  JndiObjectFactoryBean  createJOFB() {
		JndiObjectFactoryBean  jofb=new JndiObjectFactoryBean();
		jofb.setJndiName("java:/comp/env/DsJndi");
		return jofb;  //as selfless bean/factory bean it gvies  DS object when  getObject() is called
	}
	
	@Bean
	public  SimpleJdbcCall  createSJC() {
		return new SimpleJdbcCall((DataSource) createJOFB().getObject());
	}

}
