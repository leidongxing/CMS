package chapter5.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
//@EnableWebSecurity
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	 @Autowired
	 DataSource dataSource;
	 
	 @Override
     protected void configure(HttpSecurity http) throws Exception{
    	 http.authorizeRequests()
    	 .anyRequest().authenticated()
    	 .and().formLogin().and().httpBasic(); 
     }
	 
	 @Override
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		 auth
//		 .inMemoryAuthentication()
//		 .withUser("user").password("password").roles("ROLE_USER").and()
//		 .withUser("admin").password("password").authorities("ROLE_USER","ROLE_AMDIN");
		 
//		 auth.jdbcAuthentication()
//		 .dataSource(dataSource)
//		 .usersByUsernameQuery(
//		 "select username,password,true "+
//		 "from Spitter where username=?")
//		 .authoritiesByUsernameQuery(
//		  "select username,'ROLE_USER' from Spitter where username=?")
//		 .passwordEncoder(new PasswordEncoder());
		 
//		 auth
//		 .ldapAuthentication()
//		 .userSearchFilter("{uid= {0}}")
//		 .groupSearchFilter("{member={0}}")
//		 .passwordCompare()
//		 .passwordEncoder(new Md5PasswordEncoder())
//		 .passwordAttribute("passwcode");
		 
		 auth.ldapAuthentication().userSearchBase("ou=people")
		 .userSearchFilter("{uid={0}}").groupSearchBase("ou=groups")
		 .groupSearchFilter("member={0}");
//		 .contextSource().url("ldap://habuma.com/dc=habuma,dc=com");
	 } 
	 
	 
	 
}
