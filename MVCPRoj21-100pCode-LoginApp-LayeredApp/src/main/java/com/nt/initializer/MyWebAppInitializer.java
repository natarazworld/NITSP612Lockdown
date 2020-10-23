package com.nt.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import com.nt.config.RootAppConfig;
import com.nt.config.WebMVCConfig;
public class MyWebAppInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	public Class<?>[] getRootConfigClasses() {
			return new Class[] {RootAppConfig.class};  // will be used by super class onStartup(-) to get Configuration class name for Parent IOContainer
	}

	@Override
	public Class<?>[] getServletConfigClasses() {
		return new Class[] {WebMVCConfig.class};  // will be used by super class onStartup(-) to get Configuration class name for Child IOContainer	}
	}
	@Override
	public String[] getServletMappings() {
		return new String[] {"/"};  // will be used by super class onStartup(-) to get  DS url pattern
	}


}
