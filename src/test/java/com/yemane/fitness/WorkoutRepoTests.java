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

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class WorkoutRepoTests {

	@Autowired
	private WorkoutRepository repo;
	
	@Test
	public void testCreateWorkout() {
		Workout savedWorkout = repo.save(new Workout("Beginner Yoga", "$30.00"));
		
		assertThat(savedWorkout.getWorkoutId()).isGreaterThan(0);
	}
}
