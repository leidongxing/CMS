package chapter5.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import chapter5.data.SpitterRepository;
import chapter5.pojo.Spitter;

public class SpitterUserService implements UserDetailsService {
	private final SpitterRepository spitterRepository;

	@Autowired
	public SpitterUserService(SpitterRepository spitterRepository) {
		this.spitterRepository = spitterRepository;
	}
   
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Spitter spitter = spitterRepository.findByUsername(username);
		if (spitter != null) {
           List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
           authorities.add(new SimpleGrantedAuthority("ROLE_SPITTER"));
           return new User(
        	   spitter.getUsername(),
        	   spitter.getPassword(),
        	   authorities
           );
		}
		throw new UsernameNotFoundException("User '"+username +"'not found.");
	}


    
	
}
