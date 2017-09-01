package chapter4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy

public class ConcertConfig {	  
	 @Bean(name="audience")
     public Audience audience(){
    	 return new Audience();
     }
	 
}
