package com.callahanwilliam.popcorn.inventory.configuration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

/**
 * Configures the RESTful Web Service
 */
@Configuration
public class RestConfiguration {
	
	private final Log log = LogFactory.getLog(this.getClass());
	
	@Value("${spring.data.rest.basePath}")
	private String basePath;
	
	/**
	 * {@inheritDoc}
	 */
	@Bean
	public RepositoryRestConfigurer repositoryRestConfigurer() {
		return new RepositoryRestConfigurerAdapter() {
			@Override
			public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
				log.info("Configuring REST API Base Path: " + basePath);
				config.setBasePath(basePath);
			}
		};
	}
	
}
