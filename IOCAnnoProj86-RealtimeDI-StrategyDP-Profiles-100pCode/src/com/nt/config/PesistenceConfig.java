package com.nt.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
public class PesistenceConfig {
	
	@Bean
	@Profile("dev")
	public  DataSource  createApacheDS() {
		BasicDataSource bds=null;
		bds=new BasicDataSource();
		bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		bds.setUrl("jdbc:mysql:///ntsp612db");
		bds.setUsername("root");
		bds.setPassword("root");
		return bds;
	}
	
	@Bean
	@Profile("test")
	public  DataSource  createHKDSMySql() {
		HikariDataSource ds=null;
		ds=new HikariDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setJdbcUrl("jdbc:mysql:///ntsp612db");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	
	@Bean
	@Profile("uat")
	public  DataSource  createC3P0Ds()throws Exception {
		ComboPooledDataSource ds=null;
		ds=new ComboPooledDataSource();
		ds.setDriverClass("oracle.jdbc.driver.OracleDriver");
		ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUser("system");
		ds.setPassword("manager");
		return ds;
	}
	
	@Bean
	@Profile("prod")
	public  DataSource  createHKDSOracle() {
		HikariDataSource ds=null;
		ds=new HikariDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("system");
		ds.setPassword("manager");
		return ds;
	}

}
