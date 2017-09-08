package chapter4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true)

public class ConcertConfig {	  
	 @Bean(name="audience")
     public Audience audience(){
    	 return new Audience();
     }
	 
	 @Bean(name="p")
	 public  Performance doit(){
		return  new Performance();
	 }
}
