package com.yemane.fitness;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.yemane.fitness.model.Role;
import com.yemane.fitness.repository.RoleRepository;
import static org.assertj.core.api.Assertions.assertThat;

//CRUD Junit tests for RoleRepository

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepoTests {

	@Autowired
	private RoleRepository repo;

	// Create Role test
	@Test
	public void testCreateRole() {
		Role role = repo.save(new Role("Editor"));
		assertThat(role.getRoleId()).isGreaterThan(2L);
	}

	// Update Role test
	@Test
	public void getRoleTest() {
		Role role = repo.findById(3L).get();
		assertThat(role.getRoleId()).isEqualTo(3L);
	}

	// Update Role test
	@Test
	public void updateRoleTest() {
		Role role = repo.findById(3L).get();
		role.setName("Instructor");
		Role updatedRole = repo.save(role);
		assertThat(updatedRole.getName()).isEqualTo("Instructor");
	}

	// Delete Role test
	@Test
	public void deleteRoleTest() {
		Role role = repo.findById(4L).get();
		repo.delete(role);
	}

}
