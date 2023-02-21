package com.yemane.fitness.model;

import lombok.*;

import java.util.*;

import jakarta.persistence.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@ManyToMany
	@JoinTable(
			name = "user_role",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id")
			)
	private Set<Role> roles = new HashSet<>();

	@ManyToMany
	@JoinTable(
			name = "user_classes",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "class_id")
			)
	private Set<WorkoutClass> workoutClasses = new HashSet<>();
	
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	
	
	public User(String email, String password, Set<Role> roles) {
		super();
		this.email = email;
		this.password = password;
		this.roles = roles;
	}
	
	public void assignRole(Role role) {
		this.roles.add(role);
	}
	public void removeRole(Role role) {
	this.roles.remove(role);
	}

public void addClass(WorkoutClass workoutClass) {
	this.workoutClasses.add(workoutClass);
}

	public User(Long userId, Set<WorkoutClass> workoutClasses) {
		super();
		this.userId = userId;
		this.workoutClasses = workoutClasses;
	}
}
