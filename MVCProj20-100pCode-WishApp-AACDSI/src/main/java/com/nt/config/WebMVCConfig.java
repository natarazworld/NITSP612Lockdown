package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.nt.controller")
public class WebMVCConfig {

	
	//ViewResolver Configuration
	@Bean
	public  ViewResolver   createIRVR() {
		InternalResourceViewResolver irvr=new InternalResourceViewResolver();
		 //set prefixes and suffixes
		irvr.setPrefix("/WEB-INF/pages/");
		irvr.setSuffix(".jsp");
		return irvr;
	}
}
