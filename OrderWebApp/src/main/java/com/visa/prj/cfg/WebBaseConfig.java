package com.visa.prj.cfg;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
//Any class which returns a bean is a configuration
public class WebBaseConfig {
	
	@Bean(name="messageSource")
	public MessageSource getMessageSource() {
	ReloadableResourceBundleMessageSource ms= new ReloadableResourceBundleMessageSource();
	ms.setBasename("classpath:messages");
	return ms;
	}
} 
