package com.self.learning.login;

import static org.junit.Assert.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.self.learning.login.UserEnt;
import com.self.learning.login.UserRepository;
import com.self.learning.login.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	private UserService userService;
	
	@MockBean
	private UserRepository userRepository;
	
	@Test
	public void testFindByUsername() {
		UserEnt userEnt = new UserEnt(123, "hiren","abcd");
		Mockito.when(userRepository.findByUsername("hiren"))
				.thenReturn(userEnt);
		assertEquals(userEnt, userService.getUserByName("hiren"));
		assertEquals("abcd",userService.getUserByName("hiren").getPassword());
	}

	//@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

}
