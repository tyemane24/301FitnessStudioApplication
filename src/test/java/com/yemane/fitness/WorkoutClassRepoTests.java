package com.yemane.fitness;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.yemane.fitness.model.WorkoutClass;
import com.yemane.fitness.repository.WorkoutClassRepository;

//CRUD Junit Tests for WorkoutClassRepository

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class WorkoutClassRepoTests {

	@Autowired
	private WorkoutClassRepository repo;

	// Create WorkoutClass test
	@Test
	public void testCreateClass() {
		WorkoutClass workoutClass = repo.save(new WorkoutClass("3:00PM"));
		assertThat(workoutClass.getClassId()).isGreaterThan(11L);
	}

	// Get/Read Class test
	@Test
	public void testGetClass() {
		WorkoutClass workoutClass = repo.findById(12L).get();
		assertThat(workoutClass.getClassId()).isEqualTo(12L);
	}

	// Delete class test
	@Test
	public void deleteClassTest() {
		WorkoutClass workoutClass = repo.findById(12L).get();
		repo.delete(workoutClass);
	}
}
