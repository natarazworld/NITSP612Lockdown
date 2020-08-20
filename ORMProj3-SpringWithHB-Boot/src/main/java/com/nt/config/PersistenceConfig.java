package com.nt.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.nt.entity.Project;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class PersistenceConfig {
	@Autowired
	   private DataSource ds;
	
	
	@Bean(name="sesfact")
	public LocalSessionFactoryBean  createLocalSesFactBean() {   // As method call it gives LocalSessionFactoryBean object
		 LocalSessionFactoryBean bean=null;                                      // but in the internal cache it will maintain  
		 Properties props=null;                                                              // the Resultant SessionFactory object as spring bean.
		 
		 bean=new LocalSessionFactoryBean();
		 System.out.println(ds.getClass());
		 bean.setDataSource(ds);
		 bean.setAnnotatedClasses(Project.class);
		 props=new Properties();
		 props.setProperty("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
		 props.setProperty("hibernate.hbm2ddl.auto","update");
		 props.setProperty("hibernate.show_sql","true");
		 bean.setHibernateProperties(props);
		 return bean;
	}
	@Bean(name="ht")
	public  HibernateTemplate  createHT() {
		return new HibernateTemplate(createLocalSesFactBean().getObject());  // to get resultant object factory bean obj we need to call  getObject metbod
	}

}
