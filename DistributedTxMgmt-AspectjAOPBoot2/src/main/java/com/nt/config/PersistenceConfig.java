package com.nt.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.atomikos.jdbc.AtomikosDataSourceBean;

@Configuration
public class PersistenceConfig {
	
	@Bean(name="oraXADs")
	public  AtomikosDataSourceBean  createOracleXADS() {
		AtomikosDataSourceBean  ds=null;
		Properties props=null;
		ds=new AtomikosDataSourceBean();
		ds.setUniqueResourceName("OraXA");
		ds.setXaDataSourceClassName("oracle.jdbc.xa.client.OracleXADataSource");
		props=new Properties();
		props.setProperty("databaseName","xe");
		props.setProperty("URL","jdbc:oracle:thin:@localhost:1521:xe");
		props.setProperty("user","system");
		props.setProperty("password", "manager");
		ds.setXaProperties(props);
		return ds;
	}
	
	@Bean(name="mysqlXADs")
	public  AtomikosDataSourceBean  createMySqlXADS() {
		AtomikosDataSourceBean  ds=null;
		Properties props=null;
		ds=new AtomikosDataSourceBean();
		ds.setUniqueResourceName("mysqlXA");
		ds.setXaDataSourceClassName("com.mysql.cj.jdbc.MysqlXADataSource");
		props=new Properties();
		props.setProperty("databaseName","ntsp612db");
		props.setProperty("URL","jdbc:mysql:///ntsp612db");
		props.setProperty("user","root");
		props.setProperty("password", "root");
		ds.setXaProperties(props);
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
