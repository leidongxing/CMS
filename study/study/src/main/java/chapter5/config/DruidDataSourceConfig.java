package chapter5.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;

@PropertySource("classpath:jdbc.properties")
@Configuration
public class DruidDataSourceConfig {	
    @Bean 
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() { 
        return new PropertySourcesPlaceholderConfigurer(); 
    } 
    
    @Primary
    @Bean(name="datasourceDev")
    public DataSource dataSourceDev(
    		@Value("${spring.datasource.druid.development.url}")String dbUrl,
    		@Value("${spring.datasource.druid.development.username}")String username,
    		@Value("${spring.datasource.druid.development.password}")String password,
    		@Value("${spring.datasource.druid.development.driver-class-name}")String driverClassName){
		System.out.println("-----------druid data source init!!-----------");
		DruidDataSource datasource=new DruidDataSource();
		datasource.setUrl(dbUrl);
		datasource.setUsername(username);
		datasource.setPassword(password);
		datasource.setDriverClassName(driverClassName);
    	return datasource;
    }
    
    @Bean(name="datasourcePro")
    public DataSource dataSourceProduction(
    		@Value("${spring.datasource.druid.production.url}")String dbUrl,
    		@Value("${spring.datasource.druid.production.username}")String username,
    		@Value("${spring.datasource.druid.production.password}")String password,
    		@Value("${spring.datasource.druid.production.driver-class-name}")String driverClassName){
		System.out.println("-----------druid data source init!!-----------");
		DruidDataSource datasource=new DruidDataSource();
		datasource.setUrl(dbUrl);
		datasource.setUsername(username);
		datasource.setPassword(password);
		datasource.setDriverClassName(driverClassName);
    	return datasource;
    }
    
	@Bean
    public JdbcOperations jdbcTemplate(DataSource dataSource){
    	return new JdbcTemplate(dataSource);
    }
}
