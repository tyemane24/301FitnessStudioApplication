package com.yemane.fitness;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.yemane.fitness.model.Role;
import com.yemane.fitness.model.User;
import com.yemane.fitness.model.WorkoutClass;
import com.yemane.fitness.repository.UserRepository;

import jakarta.persistence.EntityManager;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepoTests {

	@Autowired
	private UserRepository user_repo;
	
	@Autowired
	private TestEntityManager entityMgr;
	
//	@Test
//	public void testCreateRoles() {
//		
//		Role adminRole = new Role("Administrator");
//		Role visitorRole = new Role("Visitor");
//		
//		entityMgr.persist(adminRole);
//		entityMgr.persist(visitorRole);
//	}
//	
//	@Test
//	public void testCreateNewUserWithOneRole() {
//		Role adminRole = entityMgr.find(Role.class, 1l);
//		User user = new User("sally@gmail.com", "sally123");
//		user.assignRole(adminRole);
//		user_repo.save(user);
//	}
	
//	@Test
//	public void testCreateNewUserWithTwoRoles() {
//		Role adminRole = entityMgr.find(Role.class, 1);
//		Role visitorRole = entityMgr.find(Role.class, 2);
//		
//		User user = new User("lidia@gmail.com", "lidia123");
//		user.assignRole(visitorRole);
//		user.assignRole(adminRole);
//		user_repo.save(user);
//	}
	
//	@Test
//	public void testAddRoleToUser() {
//		User user = user_repo.findById(1l).get();
//		Role visitorRole = entityMgr.find(Role.class, 2);
//		user.assignRole(visitorRole);
//	}
	@Test
	public void testRegisterClassToUser() {
		User user = user_repo.findById(3L).get();
		WorkoutClass workoutClass = entityMgr.find(WorkoutClass.class, 5);
		user.addClass(workoutClass);
	}
	
//	@Test
//	public void testRemoveRoleFromUser() {
//		User user = user_repo.findById(1l).get();
//		Role role = new Role(2l);
//		user.removeRole(role);
//	}
//	
}
