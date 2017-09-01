package chapter3;

import javax.sql.DataSource;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class DataSourceConfig {
	
	@Bean(name="DataSourceA",destroyMethod="shutdown")
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	@Profile("dev")
	public  DataSource ADataSource(){
		System.out.println("fdededed");
		return null;
//		return new EmbeddedDatabaseBuilder()
//		.setType(EmbeddedDatabaseType.H2)
//		.build();
	}
	
	@Bean(name="DataSourceB")
	@Profile("prod")
	@Scope(value=WebApplicationContext.SCOPE_SESSION,
	       proxyMode=ScopedProxyMode.INTERFACES)
	public  DataSource BDataSource(){
		System.out.println("aaaaaaaa");
		JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
		jndiObjectFactoryBean.setJndiName("jdbc/malordb");
		jndiObjectFactoryBean.setResourceRef(true);
		jndiObjectFactoryBean.setProxyInterfaces(javax.sql.DataSource.class);
		return (DataSource) jndiObjectFactoryBean;
	}
}  
