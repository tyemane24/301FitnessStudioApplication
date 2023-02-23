package com.yemane.fitness;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;

import com.yemane.fitness.model.User;

import com.yemane.fitness.repository.UserRepository;

//CRUD Junit Tests for UserRepository 

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepoTests {

	@Autowired
	private UserRepository user_repo;

	// Create User test
	@Test
	public void testCreateUser() {
		User user = user_repo.save(new User("Lauren@gmail.com", "lauren123"));
		assertThat(user.getUserId()).isGreaterThan(17L);
	}

	// Read/Get User test
	@Test
	public void getUserTest() {
		User user = user_repo.findById(18L).get();
		assertThat(user.getUserId()).isEqualTo(18L);
	}

	// Update User test
	@Test
	public void updateUserTest() {

		User user = user_repo.findById(18L).get();
		user.setEmail("lauren123@gmail.com");
		User userUpdated = user_repo.save(user);
		assertThat(userUpdated.getEmail()).isEqualTo("lauren123@gmail.com");
	}

	// Delete User test
	@Test
	public void deleteUserTest() {
		User user = user_repo.findById(18L).get();
		user_repo.delete(user);

	}

}
