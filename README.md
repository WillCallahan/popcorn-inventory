### Configuration Corrections

## WildFly

# Deployment

	Auto-deploy mode and manual deploy mode can be independently configured for
	zipped deployment content and exploded deployment content. This is done
	via the "auto-deploy" attributes on the deployment-scanner element in the
	standalone.xml configuration file:
	
	<deployment-scanner scan-interval="5000" relative-to="jboss.server.base.dir"
	    path="deployments" auto-deploy-zipped="true" auto-deploy-exploded="false"/>
		    

# XA Datasource

There is a bug in WildFly when data-sources are created. Use the following link
to resolve the issue. [JIRA Case](https://issues.jboss.org/browse/HAL-1155)

