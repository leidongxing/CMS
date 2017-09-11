package chapter5.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@PropertySource("classpath:jdbc.properties")
public class DruidDataSourceConfig {
	@Value("${spring.datasource.druid.url}")  
    private String dbUrl;  

    @Value("${spring.datasource.druid.username}")  
    private String username;  

    @Value("${spring.datasource.druid.password}")  
    private String password;  

    @Value("${spring.datasource.druid.driver-class-name}")  
    private String driverClassName;  
	
    @Bean 
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() { 
        return new PropertySourcesPlaceholderConfigurer(); 
    } 
	
	@Bean
    public DataSource dataSource(){
		DruidDataSource datasource=new DruidDataSource();
		datasource.setUrl(dbUrl);
		datasource.setUsername(username);
		datasource.setPassword(password);
		datasource.setDriverClassName(driverClassName);
		System.out.println("-----------druid data source init!!-----------");
    	return datasource;
    }
    
	@Bean
    public JdbcOperations jdbcTemplate(DataSource dataSource){
    	return new JdbcTemplate(dataSource);
    }
}
