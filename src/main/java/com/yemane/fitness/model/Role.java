package com.yemane.fitness.model;

import jakarta.persistence.*;
import lombok.*;

//Role entity model to represent role of each user

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleId;
	
	@Column
	private String name;

	public Role(String name) {
		super();
		this.name = name;
	}

	public Role(Long roleId) {
		super();
		this.roleId = roleId;
	}
	
	
	
	
}
