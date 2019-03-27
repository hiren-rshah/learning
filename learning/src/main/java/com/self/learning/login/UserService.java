package com.self.learning.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public List<UserEnt> getListOfUsers(){
		return userRepository.findAll();
	}
	
	public UserEnt getUserByName(String username) {
		return userRepository.findByUsername(username);
	}
}
