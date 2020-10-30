package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class WebMVCConfig {
	
	@Bean(name="messageSource")
	public  ResourceBundleMessageSource  createRBMS() {
		ResourceBundleMessageSource source=
				 new ResourceBundleMessageSource();
		   source.setBasename("com/nt/commons/validation");
		return source;
	}

}
