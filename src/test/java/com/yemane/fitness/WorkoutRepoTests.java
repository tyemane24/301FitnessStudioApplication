package com.yemane.fitness;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.yemane.fitness.model.Workout;
import com.yemane.fitness.repository.WorkoutRepository;

//CRUD Junit Tests for WorkoutRepository

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class WorkoutRepoTests {

	@Autowired
	private WorkoutRepository repo;

	// Create Workout test
	@Test
	public void testCreateWorkout() {
		Workout savedWorkout = repo.save(new Workout("Cycling", "$30.00"));

		assertThat(savedWorkout.getWorkoutId()).isGreaterThan(24L);
	}

	// Get/Read Workout test
	@Test
	public void getWorkoutTest() {
		Workout workout = repo.findById(24L).get();
		assertThat(workout.getWorkoutId()).isEqualTo(24L);

	}

	// Update Workout test
	@Test
	public void updateWorkoutTest() {
		Workout workout = repo.findById(24L).get();
		workout.setPrice("$40.00");
		Workout workoutUpdated = repo.save(workout);
		assertThat(workoutUpdated.getPrice()).isEqualTo("$40.00");
	}

	// Delete Workout test
	@Test
	public void deleteWorkoutTest() {
		Workout workout = repo.findById(24L).get();
		repo.delete(workout);
	}
}
