package com.self.learning.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.self.learning.login.security.UserPrincipal;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEnt userEnt = userRepo.findByUsername(username);
		if(userEnt == null) {
			throw new UsernameNotFoundException("User Not Available - 404");
		}
		return new UserPrincipal(userEnt);
	}

}
