package com.yemane.fitness.model;


import jakarta.persistence.*;

import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class WorkoutClass {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long classId;
	
	@Column
	private String date;
	
	@Column
	private String time;

	@ManyToOne
	@JoinColumn(name = "workout_id")
	private Workout workout;

	public WorkoutClass(String date, String time, Workout workout) {
		super();
		this.date = date;
		this.time = time;
		this.workout = workout;
	}
	
	
	
	
}
