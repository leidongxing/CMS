package chapter5.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
//@EnableWebSecurity
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
//	 @Override
//     protected void configure(HttpSecurity http) throws Exception{
//    	 http.authorizeRequests()
//    	 .anyRequest().authenticated()
//    	 .and().formLogin().and().httpBasic(); 
//     }
	 
	 @Override
	 protected void configure(AuthenticationManagerBuilder auth) {
		 auth.inMemoryAuthentication().withUser("user").password("password").roles("USER").and().withUser("admin")。password("admin").roles("USER","ADMIN");
	 }
	 
}
