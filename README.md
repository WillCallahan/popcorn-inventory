# Configuration Corrections

## WildFly

### Deployment

Auto-deploy mode and manual deploy mode can be independently configured for
zipped deployment content and exploded deployment content. This is done
via the "auto-deploy" attributes on the deployment-scanner element in the
standalone.xml configuration file:
	
	<deployment-scanner scan-interval="5000" relative-to="jboss.server.base.dir"
	    path="deployments" auto-deploy-zipped="true" auto-deploy-exploded="false"/>
		    

### XA Datasource

There is a bug in WildFly when data-sources are created. Use the following link
to resolve the issue. [JIRA Case](https://issues.jboss.org/browse/HAL-1155)

### Service Installation

WildFly can be installed as a service in windows. Ensure that the "Local System Account"
has the correct global environmental variables when installing the service or set the JAVA_HOME
variable in a `standalone.conf.bat` start-up script.

#### Steps

1. Set the `JBOSS_HOME` environmental variable to the home directory of WildFly
2. Set the `JRE_HOME` environmental variable to the home directory of the JRE
3. Set the `JAVA_HOME` environmental variable to the home directory of Java
4. Install the keystore for WildFly, set port to redirect to https (TODO Document this)
5. Move contents of `%JBOSS_HOME%\docs\contrib\scripts` to `%JBOSS_HOME%\bin`
6. Run `bin\service\service.bat install /config standalone-full.xml /controller localhost:9990 /jbossuser admin /jbosspass admin /debug`
7. Run `bin\service\service.bat start`
8. Run `bin\jboss-cli.bat --connect --controller=localhost:9990 --command=:shutdown`

#### Verification
 
- Use `for %i in (java.exe) do @echo.   %~$PATH:i` in cmd to check for paths to java that do not match the version
being utilized by the server.
- Use [PSTools](https://technet.microsoft.com/en-us/sysinternals/pstools.aspx) to view environmental variables
for the System Local Account by running `psexec.exe -i -s cmd.exe`
- Check `HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Control\Session Manager\Environment`
for set environmental variables.
