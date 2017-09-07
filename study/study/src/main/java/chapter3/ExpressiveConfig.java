package chapter3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import chapter2.BlankDisc;

@Configuration
@PropertySource("classpath:expressive.properties")
public class ExpressiveConfig {
     
	@Autowired
	Environment env;
	
	@Bean(name="demo")
	public BlankDisc disc(){
		System.out.println(env.getProperty("db.connection.count", Integer.class,33));
		return new BlankDisc(env.getProperty("disc.title","defaultValue"), env.getRequiredProperty("disc.artist"));
	}
}
