package com.nt.config;

import java.util.Properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.atomikos.jdbc.AtomikosDataSourceBean;

@Configuration
public class PersistenceConfig {
	
	@Bean(name="oraXADs")
	@ConfigurationProperties(prefix = "dtx.orads")
	public  AtomikosDataSourceBean  createOracleXADS() {
		AtomikosDataSourceBean  ds=null;
		ds=new AtomikosDataSourceBean();
		return ds;
	}
	
	@Bean(name="mysqlXADs")
	@ConfigurationProperties(prefix = "dtx.mysqlds")
	public  AtomikosDataSourceBean  createMySqlXADS() {
		AtomikosDataSourceBean  ds=null;
		ds=new AtomikosDataSourceBean();
		return ds;
	}
	
	@Bean(name="oraJt")
	public  JdbcTemplate  createOraJt() {
		return  new JdbcTemplate(createOracleXADS());
	}
	
	@Bean(name="mysqlJt")
	public  JdbcTemplate  createMysqlJt() {
		return  new JdbcTemplate(createMySqlXADS());
	}
	
	
	

}
