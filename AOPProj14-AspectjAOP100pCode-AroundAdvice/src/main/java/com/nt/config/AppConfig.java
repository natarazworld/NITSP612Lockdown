package com.nt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
//@ComponentScan(basePackages = {"com.nt.service","com.nt.aspect" })
@ComponentScan(basePackages = "com.nt")
@EnableAspectJAutoProxy()
public class AppConfig {

}
