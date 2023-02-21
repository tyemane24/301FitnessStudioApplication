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
public class Workout {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long workoutId;
	
	@Column
	private String workoutType;
	
	@Column
	private String price;

	public Workout(String workoutType, String price) {
		super();
		this.workoutType = workoutType;
		this.price = price;
	}

	
	
	
	
}
