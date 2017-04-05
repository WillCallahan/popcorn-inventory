package com.callahanwilliam.popcorn.inventory.configuration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

/**
 * Configures the RESTful Web Service
 */
@Component
public class RestConfiguration extends RepositoryRestConfigurerAdapter {
	
	private final Log log = LogFactory.getLog(this.getClass());
	
	@Value("${spring.data.rest.basePath}")
	private String basePath;
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration repositoryRestConfiguration) {
		log.info("Configuring REST API Base Path: " + basePath);
		repositoryRestConfiguration.setBasePath(basePath);
		repositoryRestConfiguration.setReturnBodyOnCreate(true);
		repositoryRestConfiguration.setReturnBodyOnUpdate(true);
	}
	
}
