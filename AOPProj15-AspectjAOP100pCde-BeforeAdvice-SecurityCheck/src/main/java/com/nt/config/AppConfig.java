package com.nt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {PersisteceConfig.class,ServiceConfig.class,AOPConfig.class})
public class AppConfig {

}
